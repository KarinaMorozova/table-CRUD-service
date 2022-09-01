package com.example.springcruddemo.repository;

import com.example.springcruddemo.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TableRepository  extends JpaRepository<BaseEntity, Integer>{
    @Modifying
    @Transactional
    String query(String queryString);
}
