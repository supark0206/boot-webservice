package com.bootWebService.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동설정, 스프링Bean읽기 생성을 모두 자동 설정한다
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
