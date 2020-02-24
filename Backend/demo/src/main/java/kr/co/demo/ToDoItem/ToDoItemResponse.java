package kr.co.demo.ToDoItem;

import kr.co.demo.ApiResponse.ApiResponse;
import lombok.Builder;

import java.util.List;

public class ToDoItemResponse extends ApiResponse<List<ToDoItem>> {

    @Builder
    public ToDoItemResponse(final List<ToDoItem> toDoItem, final List<String> errors){
        super(toDoItem);
        this.setErrors(errors);
    }
}
