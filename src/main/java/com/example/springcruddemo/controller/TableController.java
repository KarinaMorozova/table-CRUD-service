package com.example.springcruddemo.controller;

import com.example.springcruddemo.request.CreateRequest;
import com.example.springcruddemo.request.DeleteRequest;
import com.example.springcruddemo.request.InsertRequest;
import com.example.springcruddemo.request.SelectRequest;
import com.example.springcruddemo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TableController {
    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("select")
    public ResponseEntity<?> select(@RequestBody SelectRequest selectRequest) {
        try {
            String result = tableService.select(selectRequest);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateRequest createRequest) {
        try {
            tableService.create(createRequest);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody DeleteRequest deleteRequest) {
        try {
            tableService.delete(deleteRequest);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody InsertRequest insertRequest) {
        try {
            tableService.insert(insertRequest);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
