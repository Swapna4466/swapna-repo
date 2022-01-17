package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.entity.Employee;
import com.zensar.util.DBUtil;

public class EmployeeDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String query;
	private int status;

	// Create or Insert a Row Operation
	public int addEmployee(Employee employee) {
		// Insert operation starts here
		query = "INSERT INTO employee (name,age,salary) VALUES (?,?,?)";
		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getAge());
			pstmt.setInt(3, employee.getSalary());
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		// insert operation ends here
		return status;
	}

	// Update Operation
	public int update(int id, Employee employee) {
		// update operation starts here
		conn = DBUtil.getConnection();
		query = "UPDATE employee SET name=?, age=?, salary=? WHERE id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getAge());
			pstmt.setInt(3, employee.getSalary());
			pstmt.setInt(4, id);
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		// update operation ends here
		return status;
	}

	// Delete Operation
	public int delete(int id) {
		// delete operation starts here
		query = "DELETE FROM employee where id=?";
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		// delete operation ends here
		return status;
	}

	// Read All Operation
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		conn = DBUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getInt("salary"));
				employees.add(emp);
			}
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		return employees;
	}

	// Read By Id Operation
	public Employee findById(int id) {
		// findById starts here
		Employee emp = new Employee();
		conn = DBUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee where id=" + id);
			if (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getInt("salary"));
			}
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		// findById ends here
		return emp;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
	}
}