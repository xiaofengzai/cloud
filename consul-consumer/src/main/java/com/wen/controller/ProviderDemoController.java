package com.wen.controller;

import com.wen.service.ProviderDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by szty on 2018/10/17.
 */
@RestController
@Api(description = "测试")
@RequestMapping(value = "test")
public class ProviderDemoController {
    @Autowired
    ProviderDemoService providerDemoService;
    @ApiOperation( value= "hello")
    @GetMapping(value = "/{name}")
    public String test(@PathVariable("name") String name){
        return providerDemoService.hello(name);
    }
}
