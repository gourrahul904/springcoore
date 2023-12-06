package com.rays.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDaoImpl implements UserDaoInt<UserDTO> {

	@PersistenceContext
	EntityManager en;

	@Override
	public long add(UserDTO dto) {

		en.persist(dto);
		return dto.getId();
	}

	@Override
	public long addt(UserDTO dto) {

		en.persist(dto);

		return dto.getId();
	}

	@Override
	public void update(UserDTO dto) {
		en.merge(dto);

	}

	@Override
	public UserDTO finbByPk(long pk) {

		return en.find(UserDTO.class, pk);
	}

	@Override
	public void delete(UserDTO dto) {
		en.remove(dto);

	}

	@Override
	public UserDTO findByUniqueKey(String attribute, Object value) {

		CriteriaBuilder builder = en.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qroot = cq.from(UserDTO.class);

		Predicate condition = builder.equal(qroot.get(attribute), value);

		cq.where(condition);

		TypedQuery<UserDTO> queery = en.createQuery(cq);

		List<UserDTO> list = queery.getResultList();

		UserDTO dto = null;
		if (list.size() > 0) {
			dto = list.get(0);

		}
		return dto;

	}
	
	

	/*
	 * public TypedQuery<UserDTO> createCriteria(UserDTO dto, CriteriaBuilder
	 * builder) {
	 * 
	 * CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
	 * 
	 * Root<UserDTO> cr = cq.from(UserDTO.class);
	 * 
	 * TypedQuery<UserDTO> queery = en.createQuery(cq);
	 * 
	 * return queery;
	 * 
	 * }
	 */

	

	@Override
	public List search(UserDTO dto) {
		
		CriteriaBuilder builder = en.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qroot = cq.from(UserDTO.class);

	//	Predicate condition = builder.equal(qroot.get(attribute), value);

	//	cq.where(condition);

		TypedQuery<UserDTO> queery = en.createQuery(cq);

		List<UserDTO> list = queery.getResultList();

		return list;
	}

}
