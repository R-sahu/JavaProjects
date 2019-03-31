package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO dao;
	private int total ;
	private float avg;
	private String result;
	private int m1;
	private int m2;
	private int m3;
	private StudentBO bo;
	int count =0;
	
	public StudentServiceImpl(StudentDAO dao) {
		this.dao =dao;
		bo =new StudentBO();
	}

	@Override
	public String genrateResult(StudentDTO dto) throws Exception {
	
		//read m1,m2,m3 form dto class
		m1 =dto.getM1();
		m2 =dto.getM2();
		m3 =dto.getM3();
		
		//calculate total of marks
		total =m1+m2+m3;
		
		//calculate average of the marks
		avg =total/3;
		
		if(m1>35 && m2>35 && m3>35) 	
			result ="PASS";
		else 
			result ="FAIL";
		
		//set the value to bo class properties
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSaddr(dto.getSaddr());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//call insert method from DAO class
		count  =dao.insert(bo);	

		if(count==0) 
			return "Registration Failed  :: "+result;
		else
			return "Registration Success :: "+result;
	}

}
