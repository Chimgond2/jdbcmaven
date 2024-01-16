package com.ty.student.controller;

import com.ty.student.dao.StudentDao;

public class DeleteStudentById {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		studentDao.deleteStudentById(2);
	}

}
