package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.ImgBoardVO;

import java.util.List;

public interface ImgBoardDAO {
    public List<ImgBoardVO> select() throws Exception;
    public List<ImgBoardVO> selectDetail(int num) throws Exception;
}
