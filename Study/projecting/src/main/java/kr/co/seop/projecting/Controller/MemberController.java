package kr.co.seop.projecting.Controller;

import kr.co.seop.projecting.Service.MemberService;
import kr.co.seop.projecting.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService service;

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public List<String> select(@PathVariable(value = "id")String mid) throws Exception{
        List<String> list = new ArrayList<>();
        MemberVO item = service.select(mid);
        list.add(item.getMpass());
        list.add(item.getMname());
        return list;
    }

    @GetMapping("/member")
    public boolean idlist(@RequestParam(value = "mid")String mid) throws Exception{
        MemberVO item = service.idlist(mid);
        if(item.getCount() == 0){
            return false;
        }else{
            return true;
        }
    }

    @PostMapping("/signup")
    public void signup(@RequestBody MemberVO item) throws Exception{
        service.signup(item);
    }


}
