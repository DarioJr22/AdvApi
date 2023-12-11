package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.domain.dto.PostDTO;
import com.br.thomasvcgApi.domain.dto.UserDTO;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.domain.repository.UserRepository;
import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.rest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest){

        try {
            User user = new User();
            user.setLogin(userRequest.login());
            user.setPassword(userRequest.password());
            user.setEmail(userRequest.email());
            user.setRole(userRequest.role());
            userRepository.save(user);

            return new UserResponse("User created successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }

    }
    public List<UserResponse> getAllUser(){

        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        List<PostDTO> posts = new ArrayList<>();
        List<CostumerDTO> costumers = new ArrayList<>();
        try {
            users.forEach(user -> {
                user.getCostumers().forEach(costumer -> {
                    CostumerDTO costumerDTO = CostumerDTO.builder()
                            .id(costumer.getId())
                            .cpf(costumer.getCpf())
                            .costumerName(costumer.getCostumerName())
                            .email(costumer.getEmail())
                            .contact(costumer.getContact())
                            .build();
                    costumers.add(costumerDTO);
                });
                user.getPosts().forEach(post -> {
                    PostDTO postDTO = PostDTO.builder()
                            .id(post.getId())
                            .date(post.getDate())
                            .title(post.getTitle())
                            .subtitle(post.getSubtitle())
                            .build();
                    posts.add(postDTO);
                });
                UserDTO userDTO = UserDTO.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .login(user.getLogin())
                        .role(user.getRole())
                        .posts(posts)
                        .costumers(costumers)
                        .build();
                UserResponse response = new UserResponse();
                response.setUserDTO(userDTO);
                responses.add(response);
            });
            return responses;
        } catch (Exception e) {
            throw new HandlerError(e.getMessage());
        }
    }
    public UserResponse findUserById(Long idUser){

        User user = userRepository.findById(idUser)
                .orElseThrow(()->new HandlerEntityNotFoundException("User not found with id" + idUser));
        List<CostumerDTO> costumers = new ArrayList<>();
        List<PostDTO> posts = new ArrayList<>();
        try {
            user.getPosts().forEach(post -> {
                PostDTO postDTO = PostDTO.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .subtitle(post.getSubtitle())
                        .tags(post.getTags())
                        .date(post.getDate())
                        .build();
                posts.add(postDTO);
            });
            user.getCostumers().forEach(costumer -> {
                CostumerDTO costumerDTO = CostumerDTO.builder()
                        .id(costumer.getId())
                        .costumerName(costumer.getCostumerName())
                        .email(costumer.getEmail())
                        .cpf(costumer.getCpf())
                        .contact(costumer.getContact())
                        .build();
                costumers.add(costumerDTO);
            });
            return new UserResponse(UserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .costumers(costumers)
                    .posts(posts)
                    .role(user.getRole())
                    .build());
        } catch (Exception e) {
            throw new HandlerError(e.getMessage());
        }
    }

    public UserResponse updateUser(UserRequest userRequest, Long idUser){

        User user = userRepository.findById(idUser)
                .orElseThrow(()->new HandlerEntityNotFoundException("User not found with id" + idUser));
        try {
            user.setLogin(userRequest.login());
            user.setEmail(userRequest.email());
            user.setPassword(userRequest.password());
            user.setRole(userRequest.role());
            userRepository.save(user);

            return new UserResponse("Updated Successfully");
        } catch (Exception e) {
            throw new HandlerError(e.getMessage());
        }
    }

    public UserResponse deleteUser(Long idUser) {

        User user = userRepository.findById(idUser)
                .orElseThrow(()->new HandlerEntityNotFoundException("User not found with id" + idUser));
        try {
            userRepository.delete(user);

            return new UserResponse("Deleted Successfully");
        } catch (Exception e) {
            throw new HandlerError(e.getMessage());
        }
    }

}
