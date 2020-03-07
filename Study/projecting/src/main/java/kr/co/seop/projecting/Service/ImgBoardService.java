package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.VO.ImgBoardVO;

import java.util.List;

public interface ImgBoardService {
    public List<ImgBoardVO> select() throws Exception;
    public List<ImgBoardVO> select(int num) throws Exception;
}
