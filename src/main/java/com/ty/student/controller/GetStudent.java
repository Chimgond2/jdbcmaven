package com.ty.student.controller;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.StudentDto;

public class GetStudent {
	public static void main(String[] args) {
	StudentDao studentDao=new StudentDao();
     StudentDto  s=studentDao.getStudent();
     System.out.println(s);
	}
}
