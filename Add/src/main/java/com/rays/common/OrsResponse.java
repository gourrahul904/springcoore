package com.rays.common;

import java.util.HashMap;
import java.util.Map;

public class OrsResponse {
	
	public static String MESSAGE ="message";
	
	public static String INPUTERROR= "inputerror";
	
	public static String Data= "data";
	
	private boolean succcess =false;
	
	private Map<String, Object>resutl= new HashMap<String, Object>();
	
	public Map<String, Object> getResutl() {
		return resutl;
	}

	public void setResutl(Map<String, Object> resutl) {
		this.resutl = resutl;
	}

	

	public boolean isSucccess() {
		return succcess;
	}

	public void setSucccess(boolean succcess) {
		this.succcess = succcess;
	}

	public OrsResponse() {
		
	}

	public OrsResponse(Boolean succcess) {
		
		this.succcess = succcess;
	}
	
	public void addMessage(Object value) {
		resutl.put(MESSAGE, value);
		
	}
	public void addinputerror(Object value) {
		resutl.put(INPUTERROR, value);
	}
	public void addData(Object value) {
		resutl.put(Data, value);
	}
	

	
}
