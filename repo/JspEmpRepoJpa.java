package com.empdb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empdb.module.Jspemp;

public interface JspEmpRepoJpa extends JpaRepository<Jspemp, Long>{

@Query(value="select * from jspemp order by ename",nativeQuery=true)
	List<Jspemp> JspEmpByName();

@Query(value="select * from jspemp where esubject='Springboot'",nativeQuery = true)
List<Jspemp> JspEmpSpringBoot();




}
