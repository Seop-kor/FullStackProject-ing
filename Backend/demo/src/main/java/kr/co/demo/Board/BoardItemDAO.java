package kr.co.demo.Board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardItemDAO {
    public List<BoardItem> boardlist() throws Exception;
    public List<BoardItem> boardlistnum(int no) throws Exception;
    public void boardDelete(int no) throws Exception;
}
