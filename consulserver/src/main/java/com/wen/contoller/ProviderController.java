package com.wen.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by szty on 2018/10/17.
 */
@RestController
@RequestMapping(value = "demo")
public class ProviderController {
    @GetMapping(value = "test/{name}")
    public String test(@PathVariable("name") String name){
        return "hello ".concat(name);
    }
}
