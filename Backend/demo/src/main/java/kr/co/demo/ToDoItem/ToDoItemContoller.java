package kr.co.demo.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ToDoItemContoller {

    @Autowired
    ToDoItemService service;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody ToDoItemResponse select(){
        List<String> errors = new ArrayList<>();
        List<ToDoItem> item = null;
        try{
            item = service.select();
        }catch (Exception e){
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toDoItemResponse(item,errors); //여기 바꿔야함
    }

    @RequestMapping(value = "/product/{num}", method = RequestMethod.GET)
    public @ResponseBody ToDoItemResponse selectDetail(@PathVariable(value = "num")int num){
        List<String> errors = new ArrayList<>();
        List<ToDoItem> item = null;
        try{
            item = service.select(num);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toDoItemResponse(item,errors); //여기 바꿔야함
    }
}
