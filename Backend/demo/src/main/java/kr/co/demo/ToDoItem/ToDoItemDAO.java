package kr.co.demo.ToDoItem;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ToDoItemDAO {
    public List<ToDoItem> select() throws Exception;
    public List<ToDoItem> selectDetail(int num) throws Exception;
}
