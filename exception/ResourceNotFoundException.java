package com.empdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private String Resource;
	private String FieldName;
	private Object FieldValue;
	
	public ResourceNotFoundException(String resource,String fieldName,Object fieldValue) {
		super(resource+"Not found for:"+fieldName+"and value:"+fieldValue);
		Resource=resource;
		FieldName=fieldName;
		FieldValue=fieldValue;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}
	
	public String getResource() {
		return Resource;
	}

}
