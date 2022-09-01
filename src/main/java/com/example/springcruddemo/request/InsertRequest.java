package com.example.springcruddemo.request;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class InsertRequest {
    String tableName;

    @NonNull
    private List<String> fields;
    @NonNull
    private List<String> values;
}
