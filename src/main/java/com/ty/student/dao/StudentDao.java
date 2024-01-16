package com.ty.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.student.dto.StudentDto;
import com.ty.student.util.ConnectionObject;

public class StudentDao {
	Connection connection = null;

	public int saveStudent(StudentDto studentDto) {
		connection = ConnectionObject.getConnection();
		String query = "insert into student values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentDto.getId());
			preparedStatement.setString(2, studentDto.getName());
			preparedStatement.setString(3, studentDto.getEmail());
			preparedStatement.setString(4, studentDto.getPassword());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return 0;

	}

	public int updateStudent(StudentDto studentDto, int id) {
		String query = "update  student set name=?,email=?,password=? where id=?";

		connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, studentDto.getName());
			preparedStatement.setString(2, studentDto.getEmail());
			preparedStatement.setString(3, studentDto.getPassword());
			preparedStatement.setInt(4, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteStudentById(int id) {
		String query = "delete from student where id=?";
		connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	public List<StudentDto> getAllStudent() {
		List list = new ArrayList();
		String query = "select * from student";
		connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				StudentDto studentDto1 = new StudentDto();
				studentDto1.setId(resultSet.getInt(1));
				studentDto1.setName(resultSet.getString(2));
				studentDto1.setEmail(resultSet.getString(3));
				studentDto1.setPassword(resultSet.getString(4));
				list.add(studentDto1);
			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
	public StudentDto getStudent() {
		String query="select * from student";
		connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				StudentDto studentDto= new StudentDto();
				studentDto.setId(resultSet.getInt(1));
				studentDto.setName(resultSet.getString(2));
				studentDto.setEmail(resultSet.getString(3));
				studentDto.setPassword(resultSet.getString(4));
				return studentDto;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

}
