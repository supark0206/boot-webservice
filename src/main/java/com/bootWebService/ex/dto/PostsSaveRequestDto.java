package com.bootWebService.ex.dto;


import com.bootWebService.ex.domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Dto
//컨트롤러에서 사용할 클래스

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }

}
