package com.empdb.service;

import java.util.List;

import com.empdb.module.Jspemp;

public interface JspEmpService {
	
	// to save All employee
	Jspemp saveJspEmp(Jspemp emp);
	
	// to get All employees
	List <Jspemp> getAllEmp ();
	
	// to get employees by id
	Jspemp JspEmpById(Long empid);

	//to get employee by name
	List<Jspemp> JspEmpByName();

	List<Jspemp> JspEmpSpringBoot();

	// Edit employee detail
    Jspemp updateJspemp(Jspemp emp,Long empid);

	//Delete employee 
    String DeleteEmployee(Long empid);
}
