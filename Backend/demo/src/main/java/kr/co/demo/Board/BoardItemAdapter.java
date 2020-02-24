package kr.co.demo.Board;

import java.util.List;

public class BoardItemAdapter {

    public static BoardItemResponse boardItemResponse(final List<BoardItem> boardItems, List<String> errors){
        return BoardItemResponse.builder().boardItem(boardItems).errors(errors).build();
    }
}
