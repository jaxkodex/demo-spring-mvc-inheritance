package io.github.jaxkodex.demos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaxkodex on 01/05/17.
 */
@RestController
public class TestMeController extends AbstractController {

    @Override
    public ResponseEntity testMe() {
        return super.testMe();
    }

    @Override
    public ResponseEntity hello(@PathVariable String name) {
        return super.hello(name);
    }
}
