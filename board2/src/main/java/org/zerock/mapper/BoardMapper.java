package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	// �Խñ� ��ü ��ȸ
	public List<BoardVO> getList();

	// �Խñ� ���� : insert ó�� �� ������ PK���� �� �ʿ� ���� ���
	public void insert(BoardVO board);

	// �Խñ� ���� : insert ó�� �� ������ PK���� �˾ƾ� �� ���
	public void insertSelectKey(BoardVO board);

	// �Խñ� �б� : �Խñ� ��ȣ�� ���ؼ� 1���� �� �о����
	public BoardVO read(Long bno);

	// �Խñ� ���� : Ư�� �Խñ��� �����ϱ�
	// �����ϰ����ϴ� �Խñ��� �ִٸ� 1, ������ 0 ��ȯ
	public int delete(Long bno);

	// �Խñ� ���� : Ư�� �Խñ� �����ϱ�
	// �����ϰ����ϴ� �Խñ��� �ִٸ� 1, ������ 0 ��ȯ
	public int update(BoardVO board);

	// �Խñ��� ������ ��ȣ�� �о�� ������ ���� �Խñ��� ��ȸ�ϴ� �Լ�
	public List<BoardVO> getListWithPaging(Criteria cri);

	// �Խñ��� ��ü ���� ���ϱ�
	public int getTotalCount(Criteria cri);

	// �Խñۿ� ���� ��� �� ������Ʈ
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}