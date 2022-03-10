package com.bootWebService.ex.service;

import com.bootWebService.ex.domain.Posts.PostsRepository;
import com.bootWebService.ex.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성한다
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }
}
