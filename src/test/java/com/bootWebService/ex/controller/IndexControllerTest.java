package com.bootWebService.ex.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void index() {
        //given
        
        //when
        String body = this.testRestTemplate.getForObject("/",String.class);
        
        //then
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}