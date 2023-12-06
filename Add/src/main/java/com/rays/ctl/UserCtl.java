package com.rays.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.OrsResponse;
import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserFrom;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "Auth")
public class UserCtl<F extends UserFrom, T extends UserDTO, S extends UserServiceInt> {

	@Autowired
	S basedao;

	@PostMapping("signup")
	public OrsResponse regicfster(@RequestBody @Valid UserFrom form, BindingResult br) {

		OrsResponse ors = new OrsResponse();

		UserDTO dto = new UserDTO();

		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());

		basedao.add(dto);
		// ors.setSuccess(true);
		ors.setSucccess(true);
		ors.addMessage("user has been reg");

		return ors;

	}

	@PostMapping("update/{id}")
	public OrsResponse update(@PathVariable long id, @RequestBody @Valid UserFrom form, BindingResult br) {
		OrsResponse ors = new OrsResponse();

		UserDTO dto = basedao.findById(id);

		if (dto != null) {

			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setLoginId(form.getLoginId());
			dto.setPassword(form.getPassword());
			basedao.update(dto);
			ors.addMessage("user has been update");

		} else {
			// ors.setSucccess(true);
			ors.addMessage("record not found");

		}

		return ors;

	}

	@GetMapping("get/{id}")
	public OrsResponse getid(@PathVariable long id, UserFrom form) {

		OrsResponse ors = new OrsResponse();

		UserDTO dto = basedao.findById(id);

		if (dto != null) {

			dto.setFirstName(dto.getFirstName());
			dto.setLastName(dto.getLastName());
			dto.setLoginId(dto.getLoginId());
			dto.setPassword(dto.getPassword());
			ors.addData(dto);
			ors.addMessage("your get data");
		} else {
			ors.addMessage("user is not found");
		}
		return ors;

	}

	@PostMapping("delete/{id}")
	public OrsResponse delete(@PathVariable long id) {

		OrsResponse ors = new OrsResponse();

		UserDTO dto = basedao.findById(id);
		if (dto != null) {

			basedao.delete(id);
			ors.addMessage("user has been deleted");
		} else {
			ors.setSucccess(false);
			ors.addMessage("record not found5454");
		}
		return ors;

	}

	@GetMapping("login/{loginId}")
	public OrsResponse getByID(@PathVariable String loginId, UserFrom from) {

		OrsResponse ors = new OrsResponse(true);

		UserDTO dto = basedao.findByLoginId(loginId);

		if (dto != null) {
			// UserDTO dto= new UserDTO();
			dto.setId(dto.getId());
			dto.setFirstName(dto.getFirstName());
			dto.setLastName(dto.getLastName());
			dto.setLoginId(dto.getLoginId());
			dto.setPassword(dto.getPassword());
			ors.addData(dto);
			ors.addMessage("users data is get");

		} else {
			ors.setSucccess(false);
			ors.addMessage("record not found ");
		}
		return ors;
	}

	@PostMapping("search")
	public OrsResponse serarch(UserFrom form, HttpServletRequest req) {
		UserDTO dto = null;

		OrsResponse ors = new OrsResponse(true);

		List<UserDTO> list = basedao.search(dto);

		ors.addData(list);
		return ors;

	}

	@PostMapping("login")
	public OrsResponse login(@RequestBody  @Valid LoginForm form, BindingResult br) {
		OrsResponse ors = validate(br);
		
		if (!ors.isSucccess()) {
			return ors;
			
		}
		
		
		UserDTO dto = basedao.authenticate(form.getLoginId(), form.getPassword());

		
		if (dto != null) {
			ors.addData(dto);
			ors.addMessage("use is valid");

		} else {
			ors.addMessage("user is not valid");
		}
		return ors;
	}

	public OrsResponse validate(BindingResult br) {

		OrsResponse ors = new OrsResponse(true);

		if (br.hasErrors()) {
			ors.setSucccess(false);

			Map<String, String> errors = new HashMap<String, String>();

			List<FieldError> list = br.getFieldErrors();
			
			list.forEach(e->{
				errors.put(e.getField(), e.getDefaultMessage());
			});
			ors.addinputerror(errors);

		}
		return ors;
	}
}
