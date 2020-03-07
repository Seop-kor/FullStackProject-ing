package kr.co.seop.projecting.Response;

import kr.co.seop.projecting.VO.ImgBoardVO;
import lombok.Builder;

import java.util.List;

public class ImgBoardResponse extends ApiResponse<List<ImgBoardVO>> {
    @Builder
    public ImgBoardResponse(final List<ImgBoardVO> items, final List<String> errors){
        super(items);
        this.setErrors(errors);
    }
}
