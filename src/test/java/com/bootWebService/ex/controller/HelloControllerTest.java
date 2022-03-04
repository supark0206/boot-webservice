package com.bootWebService.ex.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//테스트를 진행할 때 Junit

//Web(spring Mcv)에 집중할 수 있는 어노테이션
//@Service,@Componet,@Repository 등은 사용할 수 없다, 여기서는 컨트롤러만 사용하기 때문에 선언
@WebMvcTest(controllers = HelloController.class) 

public class HelloControllerTest {

    @Autowired //스프링이 관리하는 bean을 주입 받는다
    private MockMvc mvc; // 웹API를 테스트할때 사용,스프링 MVC테스트의 시작점

    @Test
    public void hello리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello주소로 GET 요청을함
                .andExpect(status().isOk()) //mvc.perform결과 검증,200,404,500 상태 검증
                .andExpect(content().string(hello)); //mvc.perform결과 검증, 리턴하는 hello값이 맞는지 검증함
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount))
        ).andExpect(status().isOk())
                //jsomPath : JSON 응답값을 필드별로 검증할 수있는 메소드 입니다
                //$을 기준으로 필드명을 명시한다
                //여기서는 name과 amount를 검증
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }


}