package kr.co.demo.ToDoItem;

import java.util.List;

public class ToDoItemAdapter {

    public static ToDoItemResponse toDoItemResponse(final List<ToDoItem> toDoItems, List<String> errors){
        return ToDoItemResponse.builder().toDoItem(toDoItems).errors(errors).build();
    }
}
