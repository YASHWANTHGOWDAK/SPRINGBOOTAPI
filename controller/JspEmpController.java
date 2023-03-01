package com.empdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empdb.module.Jspemp;
import com.empdb.service.JspEmpService;

@RestController
public class JspEmpController {
	@Autowired
	JspEmpService service;
	
	
	@PostMapping("addJspEmp")
	public ResponseEntity<Jspemp> saveJspEmp(@RequestBody Jspemp emp){
		
		return new ResponseEntity<Jspemp>(service.saveJspEmp(emp),HttpStatus.CREATED);
	}

	@GetMapping("Employees")
	public List<Jspemp> getAllEmp(){
		return service.getAllEmp();
		
	}
	@GetMapping("Employee/{empid}")
	public ResponseEntity<Jspemp> JspEmpById(@PathVariable("empid") Long empid){
		return new ResponseEntity<Jspemp>(service.JspEmpById(empid),HttpStatus.OK);
	}
	
	@GetMapping("Employee/ByName")
		public List<Jspemp> JspEmpByName(){
		return service.JspEmpByName();
	}
	@GetMapping("Employee/Springboot")
	public List<Jspemp> JspEmpSpringBoot(){
		return service.JspEmpSpringBoot();
	}
	@PutMapping("Update/{empid}")
    public ResponseEntity<Jspemp> updateJspEmp(@RequestBody Jspemp jspemp,@PathVariable("empid")Long empid){
	return new ResponseEntity<Jspemp>(service.updateJspemp(jspemp, empid),HttpStatus.OK);
   }
	
	@DeleteMapping("delete/{empid}")
	public String DeleteEMployee(@PathVariable("empid") Long empid) {
		return service.DeleteEmployee(empid);
	}
}
