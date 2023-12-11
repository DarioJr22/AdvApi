package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.dto.PostDTO;
import com.br.thomasvcgApi.domain.entity.Post;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.domain.repository.PostRepository;
import com.br.thomasvcgApi.domain.repository.UserRepository;
import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.PostRequest;
import com.br.thomasvcgApi.rest.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public PostResponse createPost(PostRequest postRequest){
        User user = userRepository.findById(postRequest.user().getId())
                .orElseThrow(()->new HandlerEntityNotFoundException("User not found with id" + postRequest.user().getId()));
        Post post = new Post();
        post.setTitle(postRequest.title());
        post.setDate(LocalDate.now());
        post.setSubtitle(postRequest.subtitle());
        post.setContent(convertBase64(postRequest.content()));
        post.setTags(postRequest.tags());
        post.setUser(user);
        postRepository.save(post);

        return new PostResponse("Post created successfully");
    }

    public List<PostResponse> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostResponse> responses = new ArrayList<>();

        posts.forEach(post -> {
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .date(post.getDate())
                    .title(post.getTitle())
                    .subtitle(post.getSubtitle())
                    .content(post.getContent())
                    .tags(post.getTags())
                    .build();
            PostResponse response = new PostResponse();
            response.setPostDTO(postDTO);

            responses.add(response);
        });
        return responses;
    }
    public PostResponse findByPost(PostRequest postRequest) {
        Post post = postRepository.findByTitle(postRequest.title());

        return new PostResponse(PostDTO.builder()
                .id(post.getId())
                .date(post.getDate())
                .title(post.getTitle())
                .subtitle(post.getSubtitle())
                .content(post.getContent())
                .tags(post.getTags())
                .build());
    }
    public PostResponse updatePost(PostRequest postRequest, Long idPost) {
        Post post = postRepository.findById(idPost)
                .orElseThrow(()->new HandlerEntityNotFoundException("Post not found with id" + idPost));
        post.setTitle(postRequest.title());
        post.setSubtitle(postRequest.subtitle());
        post.setContent(convertBase64(postRequest.content()));
        post.setTags(postRequest.tags());
        postRepository.save(post);

        return new PostResponse("Post update successfully");
    }
    public PostResponse deletePost(Long idPost) {
        Post post = postRepository.findById(idPost)
                .orElseThrow(()->new HandlerEntityNotFoundException("Post not found with id" + idPost));
        postRepository.delete(post);
        return new PostResponse("Post delete successfully");
    }
    private String convertBase64(String content){
        try {
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            byte[] base64Encoded = Base64.getEncoder().encode(contentBytes);
            return new String(base64Encoded,StandardCharsets.UTF_8);
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }

    }



}
