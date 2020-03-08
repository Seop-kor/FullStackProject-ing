package kr.co.seop.projecting.Controller;

import kr.co.seop.projecting.Response.BoardResponse;
import kr.co.seop.projecting.Service.BoardService;
import kr.co.seop.projecting.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class BoardController {
    @Autowired
    private BoardService service;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public @ResponseBody BoardResponse boardlist(){
        List<String> errors = new ArrayList<>();
        List<BoardVO> items = null;
        try{
            items = service.boardlist();
        }catch(Exception e){
            errors.add(e.getMessage());
        }
        return BoardResponse.builder().items(items).errors(errors).build();
    }

    @RequestMapping(value = "/board/{no}", method = RequestMethod.DELETE)
    public void boardDelete(@PathVariable(value = "no")int no) throws Exception{
        service.boardlistdel(no);
    }

    @PostMapping("/board")
    public void boardwrite(@RequestBody BoardVO item) throws Exception{
        service.boardwrite(item);
    }

    @PutMapping("/board")
    public void readcount(@RequestParam int no) throws Exception{
        service.readcount(no);
    }

}
