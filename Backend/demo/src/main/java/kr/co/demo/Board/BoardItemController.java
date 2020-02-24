package kr.co.demo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BoardItemController {

    @Autowired
    BoardItemService service;


    @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
    public @ResponseBody BoardItemResponse boardlist(){
        List<String> errors = new ArrayList<>();
        List<BoardItem> items = null;
        try{
            items = service.boardlist();
        }catch(Exception e){
            errors.add(e.getMessage());
        }

        return BoardItemAdapter.boardItemResponse(items,errors);
    }

    @RequestMapping(value = "/boardlist/{no}", method = RequestMethod.GET)
    public @ResponseBody BoardItemResponse boardlist(@PathVariable(value = "no")int no){
        List<String> errors = new ArrayList<>();
        List<BoardItem> items = null;
        try{
            items = service.boardlist(no);
        }catch(Exception e){
            errors.add(e.getMessage());
        }

        return BoardItemAdapter.boardItemResponse(items,errors);
    }

    @RequestMapping(value = "/boardlist/{no}", method = RequestMethod.DELETE)
    public void boardDelete(@PathVariable(value = "no")int no) throws Exception{
        service.boardlistdel(no);
    }


}
