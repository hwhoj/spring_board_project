package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //시작 주소를 받아주는 메소드
    @GetMapping("/") //기본 주소요청이 오면
    public String index(){ //이 메소드가 호출이되고
        return "index"; //index 페이지를 띄워준다, resources의 templates 폴더
    }
}
