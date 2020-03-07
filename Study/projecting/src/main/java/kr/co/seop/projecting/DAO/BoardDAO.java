package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.BoardVO;

import java.util.List;

public interface BoardDAO {
    public List<BoardVO> boardlist() throws Exception;
    public void boardDelete(int no) throws Exception;
    public void boardwrite(BoardVO item) throws Exception;
    public void readcount(int no) throws Exception;
}
