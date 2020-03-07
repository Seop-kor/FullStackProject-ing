package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.DAO.BoardDAO;
import kr.co.seop.projecting.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO dao;

    @Override
    public List<BoardVO> boardlist() throws Exception {
        return dao.boardlist();
    }

    @Override
    public void boardlistdel(int no) throws Exception {
        dao.boardDelete(no);
    }

    @Override
    public void boardwrite(BoardVO item) throws Exception {
        dao.boardwrite(item);
    }

    @Override
    public void readcount(int no) throws Exception {
        dao.readcount(no);
    }
}
