package com.yaroslavtir;

import com.yaroslavtir.entity.SecondEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class MainService {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Object entity) {
        entityManager.persist(entity);
    }

    public void updateSecond(Long id, String name) {
        SecondEntity secondEntity = entityManager.find(SecondEntity.class, id);
        secondEntity.setName(name);
    }


}
