package com.bootWebService.ex.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
    Setter가 없는이유 : 
    getter/setter를 무작정 생성하면 해당 클래스의 인스턴스 값들이 언제 어디서
    변해야 하는지 코드상으로 명확하게 구분할 수가 없다
    그래서 Entity 클래스에서는 Setter을 절대 만들지 않는다 
*/
@Getter
@NoArgsConstructor // 기본생성자  public Posts() {} 쓴것과 똑같은 효과를 준다
@Entity //테이블에 링크될 클래스임을 나타낸다
public class Posts {


    @Id //해당 테이블의 PK필드를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성의 규칙을 나타낸다
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼을 나타낸다, 선언안한다면 기본으로 컬럼이다
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함한다
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
