package com.moviesproject.moviesproject.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@NoArgsConstructor

public class TestController {

    private HashMap<String, String> hashlist = new HashMap<>();

    @GetMapping("test/{hello}")
    public String test(@PathVariable String hello) {
        return hello;
    }

    @GetMapping("add/{name}/{surname}")
    public String addInMapp(@PathVariable String name, @PathVariable String surname) {
        hashlist.put(name, surname);
        return "Information is put in map !";
    }

    @GetMapping("find")
    public ResponseEntity<HashMap<String, String>> find() {
        return ResponseEntity.ok(hashlist);
    }

}
