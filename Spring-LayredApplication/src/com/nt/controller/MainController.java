package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;

public class MainController {
	
	private StudentService service;
	private StudentDTO dto;
	String result=null;
	
	public MainController(StudentService service) {
		this.service =service;
		dto =new StudentDTO();
	}
	
	public String process(StudentVO vo)throws Exception{
		
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setSaddr(vo.getSaddr());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		result =service.genrateResult(dto);	
		
		return result;
	}
}
