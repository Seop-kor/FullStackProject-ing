package kr.oauthpopol.project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String firstPage(){
        return "Hello World";
    }
}
