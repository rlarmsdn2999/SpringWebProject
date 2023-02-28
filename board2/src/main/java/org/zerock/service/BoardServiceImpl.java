package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper rmapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper amapper;

	@Transactional
	@Override
	public void register(BoardVO board) {
		System.out.println("register ... : " + board);
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		System.out.println("get... : " + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		System.out.println("modify...." + board);
		return mapper.update(board) == 1; // 수정이 정상적으로 이뤄지면 1 반환
	}
	
	@Transactional
	@Override
	public boolean remove(Long bno) {
		System.out.println("delete...." + bno);
		rmapper.deleteByBoard(bno);
		amapper.deleteByBno(bno);
		return mapper.delete(bno) == 1; // 삭제가 정상적으로 이뤄지면 1 반환
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		System.out.println("get List With Criteria : " + cri);

		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		System.out.println("get total count");

		return mapper.getTotalCount(cri);
	}
	
	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		System.out.println("get Attach list by bno : " + bno);
		return attachMapper.findByBno(bno);
	}
}
