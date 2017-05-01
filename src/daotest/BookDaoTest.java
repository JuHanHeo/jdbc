package daotest;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
//		selectTest();
//		updateTest();
//		deleteTest(2l);
//		selectTest();
		selectTest("누가 내 머리에 똥 쌓어 변경");

	}
	public static void insertTest(){
		BookVo vo = new BookVo();
		vo.setName("누가 내 머리에 똥 쌓어");
		vo.setPrice(10000);
		vo.setAuthorNo(1);
		new BookDao().insert(vo);
		
	}
	public static void selectTest(){
		List<BookVo> list = new BookDao().getList();
		for(BookVo l : list){
			System.out.println(l.toString());
		}
	}
	
	public static void updateTest(){
		BookVo vo = new BookVo();
		vo.setNo(1L);
		vo.setName("누가 내 머리에 똥 쌓어 변경");
		vo.setPrice(1000);
		new BookDao().update(vo);
	}
	
	public static void deleteTest(Long no){
		new BookDao().delete(no);
	}
	public static void selectTest(String name){
		BookVo vo = new BookDao().get(name);
		System.out.println(vo.toString());
	}

}
