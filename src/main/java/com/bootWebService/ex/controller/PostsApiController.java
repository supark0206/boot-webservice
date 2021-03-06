package com.bootWebService.ex.controller;


import com.bootWebService.ex.dto.PostsResponseDto;
import com.bootWebService.ex.dto.PostsSaveRequestDto;
import com.bootWebService.ex.dto.PostsUpdateRequestDto;
import com.bootWebService.ex.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    //์์ 
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    //์กฐํ
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return  postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long postsDelete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
