package kr.co.demo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardItemService {
    @Autowired
    BoardItemDAO dao;

    public List<BoardItem> boardlist() throws Exception{
        return dao.boardlist();
    }

    public List<BoardItem> boardlist(int no) throws Exception{
        return dao.boardlistnum(no);
    }

    public void boardlistdel(int no) throws Exception{
        dao.boardDelete(no);
    }
}
