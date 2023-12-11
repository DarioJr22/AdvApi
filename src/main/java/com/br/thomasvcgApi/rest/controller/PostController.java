package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.rest.request.PostRequest;
import com.br.thomasvcgApi.rest.response.PostResponse;
import com.br.thomasvcgApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> responses = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
    @GetMapping(value = "/title")
    public ResponseEntity<PostResponse> findByPost(@RequestBody PostRequest request) {
        PostResponse response = postService.findByPost(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping(value = "/{idPost}")
    public ResponseEntity<PostResponse> updatePost(@RequestBody PostRequest request,@PathVariable Long idPost) {
        PostResponse response = postService.updatePost(request,idPost);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping(value = "/{idPost}")
    public ResponseEntity<PostResponse> deletePost(@PathVariable Long idPost) {
        PostResponse response = postService.deletePost(idPost);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
