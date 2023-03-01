package com.empdb.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empdb.exception.ResourceNotFoundException;
import com.empdb.module.Jspemp;
import com.empdb.repo.JspEmpRepoJpa;
import com.empdb.service.JspEmpService;

@Service
public class JspEmpServiceImp implements JspEmpService{

	@Autowired
	JspEmpRepoJpa repo;
	
	
	@Override
	public Jspemp saveJspEmp(Jspemp emp) {
	
		return repo.save(emp);
	}
	@Override
	public List<Jspemp> getAllEmp() {
		
		return repo.findAll();
	}
	@Override
	public Jspemp JspEmpById(Long empid) {
		Optional<Jspemp> emp=repo.findById(empid); 
	    if(emp.isPresent()) {
	    	 
		return emp.get();
	    }
	    else {
	    	throw new ResourceNotFoundException("Employee","EMPID",empid);
	    }
	}
	@Override
	public List<Jspemp> JspEmpByName() {
		
		return repo.JspEmpByName();
	}
	@Override
	public List<Jspemp> JspEmpSpringBoot() {
		
		return repo.JspEmpSpringBoot();
	}
	@Override
	public Jspemp updateJspemp(Jspemp emp, Long empid) {
		Jspemp existingEmp=repo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee","EMPID",empid));
		existingEmp.setEname(emp.getEname());
		existingEmp.setEsubject(emp.getEsubject());
		existingEmp.setEmail(emp.getEmail());
		existingEmp.setEphno(emp.getEphno());
		repo.save(existingEmp);
		return existingEmp;
	}
	@Override
	public String DeleteEmployee(Long empid) {
		// TODO Auto-generated method stub
		Jspemp jspemp=repo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee", "empid", empid));
		repo.delete(jspemp);
		return "Employee deleted";
		}
	
	

}
