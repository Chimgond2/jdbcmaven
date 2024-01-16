package com.ty.student.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.StudentDto;

public class GetAllStudent {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		List li=studentDao.getAllStudent();
		System.out.println(li);
		
		
	}

}
