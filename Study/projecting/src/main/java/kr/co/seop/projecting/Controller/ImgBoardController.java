package kr.co.seop.projecting.Controller;

import kr.co.seop.projecting.Response.ImgBoardResponse;
import kr.co.seop.projecting.Service.ImgBoardService;
import kr.co.seop.projecting.VO.ImgBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ImgBoardController {
    @Autowired
    private ImgBoardService service;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody ImgBoardResponse select(){
        List<String> errors = new ArrayList<>();
        List<ImgBoardVO> item = null;
        try{
            item = service.select();
        }catch (Exception e){
            errors.add(e.getMessage());
        }
        return ImgBoardResponse.builder().items(item).errors(errors).build(); //여기 바꿔야함
    }

    @RequestMapping(value = "/product/{num}", method = RequestMethod.GET)
    public @ResponseBody ImgBoardResponse selectDetail(@PathVariable(value = "num")int num){
        List<String> errors = new ArrayList<>();
        List<ImgBoardVO> item = null;
        try{
            item = service.select(num);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
        return ImgBoardResponse.builder().items(item).errors(errors).build(); //여기 바꿔야함
    }

}
