package com.example.springcruddemo.repository;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class TableRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public String query(String queryString) {
        Query query = entityManager.createNativeQuery(queryString);

        StringBuilder builder = new StringBuilder();
        if (queryString.toLowerCase().startsWith("select")) {
            for (Object obj: query.getResultList()) {
                String str = obj.toString() + "; \n";
                builder.append(str);
            }
        } else {
            query.executeUpdate();
        }
        return builder.toString();
    }
}
