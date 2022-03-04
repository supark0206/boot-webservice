package com.bootWebService.ex.controller;

import com.bootWebService.ex.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 json을 반환하는 컨트롤러로 만든다
//예전에는 ResponseBody를 각메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각
@RestController 
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        //@RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다
        return new HelloResponseDto(name,amount);
    }
}
