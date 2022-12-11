package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		System.out.println("register....." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		System.out.println("get...." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		System.out.println("modify...."+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		System.out.println("remove...."+bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		System.out.println("getList......");
		return mapper.getList();
	}
}
