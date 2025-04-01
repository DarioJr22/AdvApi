package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.domain.entity.Post;
import com.br.thomasvcgApi.domain.repository.PostRepository;
import com.br.thomasvcgApi.rest.request.PostRequest;
import com.br.thomasvcgApi.rest.request.TagRequest;
import com.br.thomasvcgApi.rest.response.PostResponse;
import com.br.thomasvcgApi.rest.response.TagResponse;
import com.br.thomasvcgApi.service.PostService;
import com.br.thomasvcgApi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;
    @Autowired
    private PostRepository postRepository;

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

    @GetMapping(value = "/tags")
    public ResponseEntity<List<String>> getAllTags(){
        List<String> tags = tagService.listarTagsDistintas();
        return ResponseEntity.status(HttpStatus.OK).body(tags);
    }

    @PostMapping(value = "/tags/{newTag}")
    public ResponseEntity<TagResponse> postTag(@PathVariable("newTag") String tag){
        String createTag = tagService.createTag(tag);
        TagResponse t = new TagResponse();
        t.setNewTag(createTag);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PutMapping(value = "/tags")
    public ResponseEntity<TagResponse> putTag(@RequestBody TagRequest tagRequest){
        String tagRequest1 = tagService.updateTag(tagRequest.getNewTag(),tagRequest.getOldTag());
        TagResponse t = new TagResponse();
        t.setNewTag(tagRequest1);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @DeleteMapping(value = "/tags/{tag}")
    public ResponseEntity<TagResponse> deleteTag(@PathVariable("tag") String tag){
        tagService.deleteTag(tag);
        TagResponse t = new TagResponse();
        t.setNewTag(tag);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }




    @GetMapping(value = "/title")
    public ResponseEntity<PostResponse> findByPost(@RequestBody PostRequest request) {
        PostResponse response = postService.findByPost(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{idPost}")
    public ResponseEntity<Post> findById(@PathVariable Long idPost){
        Post response = postRepository.findById(idPost).orElseThrow();
        response.setContent(postService.decodeBase64(response.getContent()));
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
