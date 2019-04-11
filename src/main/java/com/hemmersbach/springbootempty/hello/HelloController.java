package com.hemmersbach.springbootempty.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController{

    @RequestMapping("/")
    public String index() {
        String strRestResponse = "Angel test. I am here first @RequestMapping";
        return strRestResponse;
    }

    @RequestMapping("/testA")
    public String indexA() {
        String strRestResponse = "I am in testA";
        return  strRestResponse;
    }

    @RequestMapping("/testB")
    public String indexB() {
        String strRestResponse = "I am in testB";
        return  strRestResponse;
    }


}