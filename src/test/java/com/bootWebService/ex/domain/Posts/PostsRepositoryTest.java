package com.bootWebService.ex.domain.Posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    //보통은 배포전 전체 테스트를 수행할 때 데이터간 침범을 막기 위해 사용합니다
    @After 
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //postsRepository.save 테이블 posts에 instrt/update 쿼리를 실행합니다
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("박정현")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); //findAll 모든 데이터를 조회해오는 메소드입니다

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }

}