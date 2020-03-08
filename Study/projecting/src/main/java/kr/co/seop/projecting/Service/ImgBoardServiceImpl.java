package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.DAO.ImgBoardDAO;
import kr.co.seop.projecting.VO.ImgBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgBoardServiceImpl implements ImgBoardService {
    @Autowired
    private ImgBoardDAO dao;

    @Override
    public List<ImgBoardVO> select() throws Exception {
        return dao.select();
    }

    @Override
    public List<ImgBoardVO> select(int num) throws Exception {
        return dao.selectDetail(num);
    }
}
