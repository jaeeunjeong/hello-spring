package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")//hello로 들어오면 자동으로 맵핑
    public String hello(Model model){
        model.addAttribute("dataText", "hello!!");//모델에서의 키값.
        return "hello";//반환될 템플릿 페이지
    }

    @GetMapping("hello-mvc")
    public String helloMbc(@RequestParam(value = "name", required = false) String nameData, Model model ){
    //http://localhost:8080/hello-mvc?name=spring!!!!로 호출하면
    // 안녕하세요. spring!!!!으로 출력된다.
        model.addAttribute("name", nameData);//어트리부트가 키임
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//응답 바디 부분에 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){ //html 태그들 없이 바로 출력됨.
        return "hello " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        //private 라서 외부에서 사용 불가.
        //get, set으로 외부에서 사용하게끔.
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
