package com.example.springcruddemo.request;


import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CreateRequest {
    String tableName;

    @NonNull
    private List<String> fields;
}
