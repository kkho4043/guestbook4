package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private DataSource dataSource;	

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private void getConnection() {
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

//insert========================================================	
	public int guestInsert(GuestVo guestVo) {

		getConnection();
		int count = 0;
		try {
			String query = "";
			query += " insert into guestbook1 ";
			query += " values(seq_guest_no.nextval,?,?,?,sysdate) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, guestVo.getName());
			pstmt.setString(2, guestVo.getPassword());
			pstmt.setString(3, guestVo.getContent());
			
			count = pstmt.executeUpdate();

			System.out.println("[" + count + "삽입완료.]");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	
		close();
		return count;
	}
//list========================================================	
	public List<GuestVo> getguestList() {

		List<GuestVo> guestList = new ArrayList<GuestVo>();

		getConnection();
		try {

			// SQL�� �غ� / ���ε� / ����
			String query = "";

			query += " SELECT no, ";
			query += " 		  name, ";
			query += "        password, ";
			query += "        content, ";
			query += "        reg_date ";
			query += " FROM guestbook1 ";
			query += " order by no asc";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// ���ó��
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				String content = rs.getString("content");
				String date = rs.getString("reg_date");
				GuestVo vo = new GuestVo(no,name,pwd,content,date);
				guestList.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("errorddd:" + e);
		}
		close();
		return  guestList;
	}
	
	
//onelist========================================================	
		public GuestVo getList(int guestno) {
			getConnection();
			GuestVo getList = new GuestVo();
			try {

				// SQL�� �غ� / ���ε� / ����
				String query = "";

				query += " SELECT no, ";
				query += " 		  name, ";
				query += "        password, ";
				query += "        content, ";
				query += "        reg_date ";
				query += " FROM guestbook1 ";
				query += " where no = ? ";
				query += " order by no asc";

				pstmt = conn.prepareStatement(query);
				
		
				pstmt.setInt(1, guestno);
				rs = pstmt.executeQuery();
				// ���ó��
				while (rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String pwd = rs.getString("password");
					String content = rs.getString("content");
					String date = rs.getString("reg_date");
					getList = new GuestVo(no,name,pwd,content,date);
				}
			} catch (SQLException e) {
				System.out.println("errorddd:" + e);
			}
			close();
			return  getList;
		}
	
//delete=======================================================
	public int guestDelete(int no) {
		getConnection();
		int count = 0;
		try {

			String query = "";
			query += " delete from guestbook1 ";
			query += " where no = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);

			count = pstmt.executeUpdate();

			// 4.���ó��
			System.out.println("[" + count + "잘 삭제됨.]");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		return count;
	}


//update=======================================================
	public int guestupdate(GuestVo guestVo) {
		getConnection();
		int count = 0;
		try {

			String query = "";
			query += " update guestbook1 ";
			query += " set name = ?, ";
			query += "     content = ? ,";
			query += "     reg_date = sysdate";
			query += " where no = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, guestVo.getName());
			pstmt.setString(2, guestVo.getContent());
			pstmt.setInt(3, guestVo.getGuestno());

			count = pstmt.executeUpdate();

			// 4.���ó��
			System.out.println("[" + count + "변경완료.]");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		return count;
	}
}
