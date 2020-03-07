package kr.co.seop.projecting.Response;

import kr.co.seop.projecting.VO.BoardVO;
import lombok.Builder;

import java.util.List;

public class BoardResponse extends ApiResponse<List<BoardVO>> {
    @Builder
    public BoardResponse(final List<BoardVO> items, final List<String> errors){
        super(items);
        this.setErrors(errors);
    }
}
