package com.ty.student.controller;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.StudentDto;

public class TestStudentUpdate {
	public static void main(String[] args) {
		
		StudentDto studentDto=new StudentDto();
		
		studentDto.setName("raja");
		studentDto.setEmail("raja@gmail.com");
		studentDto.setPassword("raja@12q");
		
		StudentDao studentDao=new StudentDao();
		int res=studentDao.updateStudent(studentDto,1);
		if(res>0) {
			System.out.println("updated");
		}
		else {
			System.out.println("not");
		}
	}

}
