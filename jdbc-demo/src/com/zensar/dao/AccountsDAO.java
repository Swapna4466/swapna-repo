package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.entity.Accounts;
import com.zensar.util.DBUtil;

public class AccountsDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String query;
	private int status;

	// Read All Operation
	public List<Accounts> findAll() {
		List<Accounts> accounts = new ArrayList<Accounts>();
		conn = DBUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Accounts");
			while (rs.next()) {
				Accounts acc = new Accounts();
				acc.setAccountId(rs.getInt("accountId"));
				acc.setAccountType(rs.getString("accountType"));
				acc.setInterestRate(rs.getFloat("InterestRate"));
				acc.setSubcategory(rs.getString("subcategory"));
				acc.setMinimum_bal(rs.getDouble("minimum_bal"));
				accounts.add(acc);
			}
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		return accounts;
	}

	public int addAccount(Accounts acc) {
		query = "INSERT INTO accounts (accountType,InterestRate,subcategory,minimum_bal) VALUES (?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, acc.getAccountType());
			pstmt.setFloat(2, acc.getInterestRate());
			pstmt.setString(3, acc.getSubcategory());
			pstmt.setDouble(4, acc.getMinimum_bal());
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		return status;
	}

	public Accounts findById(int id) {
		Accounts acc = new Accounts();
		conn = DBUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from accounts where accountId=" + id);
			if (rs.next()) {
				acc.setAccountId(rs.getInt("accountId"));
				acc.setAccountType(rs.getString("accountType"));
				acc.setInterestRate(rs.getFloat("InterestRate"));
				acc.setSubcategory(rs.getString("subcategory"));
				acc.setMinimum_bal(rs.getDouble("minimum_bal"));
			}
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		return acc;
	}

	public int update(int accountId, Accounts acc) {
		conn = DBUtil.getConnection();
		query = "UPDATE accounts SET accountType=?, InterestRate=?, subcategory=?,minimum_bal=? WHERE accountId=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, acc.getAccountType());
			pstmt.setFloat(2, acc.getInterestRate());
			pstmt.setString(3, acc.getSubcategory());
			pstmt.setDouble(4, acc.getMinimum_bal());
			pstmt.setInt(5, accountId);
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		// update operation ends here
		return status;
	}

	public int delete(int id) {
		query = "DELETE FROM accounts where accountId=?";
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			status = 0;
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception Caught : " + e.getMessage());
		}
		return status;
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
