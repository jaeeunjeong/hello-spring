package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")//hello로 들어오면 자동으로 맵핑
    public String hello(Model model){
        model.addAttribute("dataText", "hello!!");//모델에서의 키값.
        return "hello";//반환될 템플릿 페이지
    }
}
