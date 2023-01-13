package com.example.springproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;

@Controller
public class main_controller {

    // MVC 방식 - 그대로 HTML 파일 반환
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "반갑습니다.");
        return "hello";
    }

    // MVC 방식 - 값을 입력 받은 후 변환된 HTML 파일 반환
    @GetMapping("hello-MVC")
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_mvc";
    }

    // API 방식 - 문자열을 반환
    @GetMapping("hello-API")
    @ResponseBody
    public String helloAPI(@RequestParam("name") String name){
        return "Hello "+name;
    }

    // API 방식 - 객체 -> JSON 을 반환
    @GetMapping("hello-API2")
    @ResponseBody
    public Hello helloAPI2(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
