package io.github.jaxkodex.demos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jaxkodex on 01/05/17.
 */
public abstract class AbstractController {

    @RequestMapping("/api/test")
    public ResponseEntity testMe () {
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/api/test2")
    public ResponseEntity testMe2 () {
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/api/hello/{name}")
    public ResponseEntity hello (@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s\n", name));
    }

    @RequestMapping("/api/hello2/{name}")
    public ResponseEntity hello2 (@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s\n", name));
    }
}
