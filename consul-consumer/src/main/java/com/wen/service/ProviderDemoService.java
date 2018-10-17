package com.wen.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by szty on 2018/10/17.
 */
@FeignClient(value = "consul-service")
public interface ProviderDemoService {
    @GetMapping(value = "/demo/test/{name}")
    String hello(@PathVariable(value = "name") String name);
}
