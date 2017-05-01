package daotest;

import java.util.List;

import dao.AuthorDao;
import vo.AuthorVO;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		selectTest();
//		selectTest(4l);
		deleteTest(4l);
		selectTest();

	}
	public static void insertTest(){
		AuthorVO vo = new AuthorVO();
		
		vo.setName("robert");
		vo.setBio("abcdefghijklmnopqrstuvwxyz");
		
		new AuthorDao().insert(vo);
		
	}
	public static void selectTest(){
		List<AuthorVO> list = new AuthorDao().getList();
		
		for(AuthorVO n : list){
			System.out.println(n.toString());
		}
	}
	
	public static void selectTest(Long no){
		AuthorVO vo = new AuthorDao().get(no);
		System.out.println(vo.toString());
	}
	
	public static void deleteTest(Long no){
		new AuthorDao().delete(no);
	}

}
