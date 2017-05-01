package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		// TODO Auto-generated method stub
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Connection 하기
			String url ="jdbc:mysql://localhost:3306/employees";
			conn = DriverManager.getConnection(url,"hr","hr");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL문 실행
			String sql = "select dept_no, dept_name from departments";
			rs = stmt.executeQuery(sql);
			
			//5. fetch row(row를 하나씩 가져오기)
			while(rs.next()){
				String deptNo = rs.getString(1);
				String deptName = rs.getString(2);
				System.out.println(deptNo + ", " + deptName);
			}
			
			
			
			System.out.println("연결 성공!!");
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("jdbc Driver를 찾을 수 없습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//자원 정리
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
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
