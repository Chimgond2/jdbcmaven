package com.ty.student.controller;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.StudentDto;

public class TestStudentInserted {
	public static void main(String[] args) {
		StudentDto studentDto=new StudentDto();
		studentDto.setId(2);
		studentDto.setName("vinay");
		studentDto.setEmail("vinay@gmail.com");
		studentDto.setPassword("321@mov");
		StudentDao studentDao=new StudentDao();
		studentDao.saveStudent(studentDto);
		if(studentDto!=null) {
			System.out.println("inserted");
		}
		else {
			System.out.println("not inserted");
		}
	}

}
