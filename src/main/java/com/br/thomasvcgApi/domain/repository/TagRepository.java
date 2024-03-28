package com.br.thomasvcgApi.domain.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Transactional
public class TagRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<String> findAllDistinctTags(){
        //Método de trazer consultas e persistir os dados no banco usando query's
        //Muito util se seu atributo for uma tabela que vc não tem uma entidade pra gerenciar.
        return entityManager.createNativeQuery("SELECT DISTINCT tags FROM post_tags",String.class).getResultList();
    }

    public String createTag(String novaTag){
        entityManager.createNativeQuery("INSERT INTO post_tags (id_post,tags) values (10,?)").setParameter(1,novaTag).executeUpdate();
        return novaTag;
    }

    public String updateTag(String tagNova, String tagAntiga){
        entityManager.createNativeQuery("UPDATE post_tags SET tags = (?) WHERE tags = ?")
                .setParameter(1,tagNova)
                .setParameter(2,tagAntiga)
                .executeUpdate();
        return tagNova;
    }

    public void deleteTag(String tagToDelete){
        entityManager.createNativeQuery("DELETE FROM post_tags WHERE tags = ?")
                .setParameter(1,tagToDelete)
                .executeUpdate()
                ;
    }



}
