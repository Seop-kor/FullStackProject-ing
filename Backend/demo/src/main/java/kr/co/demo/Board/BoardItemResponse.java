package kr.co.demo.Board;

import kr.co.demo.ApiResponse.ApiResponse;
import lombok.Builder;

import java.util.List;

public class BoardItemResponse extends ApiResponse<List<BoardItem>> {

    @Builder
    public BoardItemResponse(final List<BoardItem> boardItem, final List<String> errors){
        super(boardItem);
        this.setErrors(errors);
    }
}
