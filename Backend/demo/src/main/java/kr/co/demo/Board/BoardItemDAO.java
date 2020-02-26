package kr.co.demo.Board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardItemDAO {
    public List<BoardItem> boardlist() throws Exception;
    public void boardDelete(int no) throws Exception;
    public void boardwrite(BoardItem item) throws Exception;
    public void readcount(int no) throws Exception;
}
