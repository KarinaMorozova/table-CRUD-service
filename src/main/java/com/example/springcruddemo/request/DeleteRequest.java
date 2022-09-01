package com.example.springcruddemo.request;

import lombok.Data;

@Data
public class DeleteRequest {
    String tableName;

    String condition;
}
