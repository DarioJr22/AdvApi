package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<String> listarTagsDistintas(){
        return tagRepository.findAllDistinctTags();
    }

    public String createTag(String newTag){
       return tagRepository.createTag(newTag);
    }

    public String updateTag(String newTag, String olderTag){
        return tagRepository.updateTag(newTag,olderTag);
    }

    public void deleteTag(String deletableTag){
         tagRepository.deleteTag(deletableTag);
    }

}
