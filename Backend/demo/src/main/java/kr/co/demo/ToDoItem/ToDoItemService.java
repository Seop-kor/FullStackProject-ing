package kr.co.demo.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {
    @Autowired
    ToDoItemDAO dao;

    public List<ToDoItem> select() throws Exception{
        return dao.select();
    }

    public List<ToDoItem> select(int num) throws Exception{
        return dao.selectDetail(num);
    }
}
