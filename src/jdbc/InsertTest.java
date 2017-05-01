package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		// TODO Auto-generated method stub
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Connection 하기
			String url ="jdbc:mysql://localhost:3306/employees?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"hr","hr");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL문 실행 (업데이트는 업데이트한 로우의 수가 나온다 정수형 )
			String sql = "insert into member values(null,'herjoon1378@naver.com', password('1111'), '허허허', '개발',now())";
			int count = stmt.executeUpdate(sql);
			
			
			System.out.println(count);
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
