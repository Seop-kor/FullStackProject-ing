package kr.co.demo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
    @Autowired
    MemberService service;

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public List<String> select(@PathVariable(value = "id")String mid) throws Exception{
        List<String> list = new ArrayList<>();
        MemberItem item = service.select(mid);
        list.add(item.getMpass());
        list.add(item.getSalt());
        list.add(item.getMname());
        return list;
    }

    @GetMapping("/member")
    public boolean idlist(@RequestParam(value = "mid")String mid) throws Exception{
        MemberItem item = service.idlist(mid);
        if(item.getCount() == 0){
            return false;
        }else{
            return true;
        }
    }

    @PostMapping("/signup")
    public void signup(@RequestBody MemberItem item) throws Exception{
        service.signup(item);
    }
}
