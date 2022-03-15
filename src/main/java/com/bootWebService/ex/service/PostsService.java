package com.bootWebService.ex.service;

import com.bootWebService.ex.domain.Posts.Posts;
import com.bootWebService.ex.domain.Posts.PostsRepository;
import com.bootWebService.ex.dto.PostsListResponseDto;
import com.bootWebService.ex.dto.PostsResponseDto;
import com.bootWebService.ex.dto.PostsSaveRequestDto;
import com.bootWebService.ex.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성한다
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("해당 게시글이 없습니다 id = " + id));
                posts.update(requestDto.getTitle(),requestDto.getContent());
                return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다 id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다, id = "+ id));
        postsRepository.delete(posts);//JpaRepository에서 지원하는 delete 메소드를 이용해서 삭제함
    }

}
