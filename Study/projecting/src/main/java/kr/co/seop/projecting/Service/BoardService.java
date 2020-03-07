package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.VO.BoardVO;

import java.util.List;

public interface BoardService {
    public List<BoardVO> boardlist() throws Exception;
    public void boardlistdel(int no) throws Exception;
    public void boardwrite(BoardVO item) throws Exception;
    public void readcount(int no) throws Exception;
}
