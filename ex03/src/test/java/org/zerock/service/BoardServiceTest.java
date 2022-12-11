package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {
	@Setter
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		System.out.println(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		System.out.println("생성된 게시물의 번호 : "+board.getBno());
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board ->System.out.println(board));
	}
	
	@Test
	public void testGet() {
		System.out.println(service.get(1L));
	}
	
	@Test
	public void testDelete() {
		System.out.println("REMOVE RESULT : "+service.remove(2L));
	}
	
	@Test
	public void testupdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		board.setTitle("제목 수정합니다");
		System.out.println("MODIFY RESULT : "+service.modify(board));
	}
}



























