package com.example.springcruddemo.service;

import com.example.springcruddemo.repository.TableRepository;
import com.example.springcruddemo.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository repository) {
        this.tableRepository = repository;
    }

    public String select(SelectRequest selectRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select ");

        for (String field: selectRequest.getFields()) {
            stringBuilder.append(field).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        String temp = " from " + selectRequest.getTableName() + ";";
        stringBuilder.append(temp);
        return tableRepository.query(stringBuilder.toString());
    }

    public void create(CreateRequest createRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp = "create table " + createRequest.getTableName() + " (";
        stringBuilder.append(temp);

        for (String field: createRequest.getFields()) {
            stringBuilder.append(field).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        stringBuilder.append(");");
        tableRepository.query(stringBuilder.toString());
    }

    public void delete(DeleteRequest deleteRequest) {
        StringBuilder stringBuilder = new StringBuilder();

        String temp = "delete from " + deleteRequest.getTableName();
        stringBuilder.append(temp);
        if (deleteRequest.getCondition() == null && !("").equals(deleteRequest.getCondition())) {
            stringBuilder.append(" where ").append(deleteRequest.getCondition()).append(";");
        }

        stringBuilder.append(";");
        tableRepository.query(stringBuilder.toString());
    }

    public void insert(InsertRequest insertRequest) {
        StringBuilder stringBuilder = new StringBuilder();

        String temp = "insert into " + insertRequest.getTableName() + " (";
        stringBuilder.append(temp);
        for (String field : insertRequest.getFields()) {
            stringBuilder.append(field).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        stringBuilder.append(") values (");
        for (String value : insertRequest.getValues()) {
            temp = "'" + value + "', ";
            stringBuilder.append(temp);
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(");");
        tableRepository.query(stringBuilder.toString());
    }
}
