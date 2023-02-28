package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	public void insert(BoardAttachVO vo);

	public void delete(String uuid);

	// �Խñ� ��ȸ��, �Խñۿ� ÷�ε� ÷������ ��ȸ�� �޼ҵ�
	public List<BoardAttachVO> findByBno(Long bno);
	
	public String deleteByBno(Long bno);
}