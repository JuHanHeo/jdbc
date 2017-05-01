package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import vo.BookVo;

public class BookDao {
	private Connection getConnection() throws SQLException{

		Connection conn = null;


		//1. 드라이버 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. Connection 하기
			String url ="jdbc:mysql://localhost:3306/employees?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"hr","hr");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}
	public List<BookVo> getList(){
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		List<BookVo> list = new ArrayList<BookVo>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select no, name, price, author_no from books";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int authorNo = rs.getInt(4);
				BookVo vo = new BookVo();

				vo.setNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setAuthorNo(authorNo);
				list.add(vo);

			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{

			try {
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}
	public BookVo get(String name){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		BookVo vo = null;

		try {
			conn = getConnection();
			String sql = "select no, name, price, author_no from books where name = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();
			if(rs.next()){
				Long no = rs.getLong(1);
				String name2 = rs.getString(2);
				int price = rs.getInt(3);
				int authorNo = rs.getInt(4);
				vo = new BookVo();

				vo.setNo(no);
				vo.setName(name2);
				vo.setPrice(price);
				vo.setAuthorNo(authorNo);

			}

			return vo;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{

			try {
				if(rs!=null){rs.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}
	public boolean delete(Long no){
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {

			conn=getConnection();

			String sql = "delete from books where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);

			int count = pstmt.executeUpdate();
			
			return (count==1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			//자원 정리
			try {
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	public boolean insert(BookVo vo){
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {

			conn=getConnection();

			String sql = "insert into books values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getAuthorNo());

			int count = pstmt.executeUpdate();
			
			return (count==1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			//자원 정리
			try {
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	public boolean update(BookVo vo){
		
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {

			conn=getConnection();

			String sql = "update books set name = ?, price =? where no = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getNo());

			int count = pstmt.executeUpdate();
			
			return (count==1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			//자원 정리
			try {
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
