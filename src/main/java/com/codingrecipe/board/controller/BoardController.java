package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
// /board라는 주소는 대표적으로 모두 포함되어있으므로 리퀘스트매핑이라는 어노테이션을 사용하면 겟매핑에서 board를 안써도된다.
// /board로 시작하는 주소를 컨트롤러가 먼저 찾는 구조
public class BoardController {

    private final BoardService boardService; //생성자 주입방식으로 의존성을 주입받는다
    @GetMapping("/save") //요청하는 방식은 버튼이됐든 링크가 됐든 Get으로 받아온다
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save") //save.html에서 post요청이 들어올때 실행됨
    public String save(@ModelAttribute BoardDTO boardDTO){
        //@ModelAttribute 어노테이션에 의해 BoardDTO 클래스 객체를 찾아서
        //save.html에서 받아온 name과 BoardDTO의 변수의 필드값이 같다면 필드에대한 setter를 알아서 호출하면서
        //save.html에서 담겨진 값들을 Setter 메소드로 각각 담아준다. 간단하게 입력값을 가져올수 있다.
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);

        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model){
        //전체 목록을 DB로부터 가져와야한다. 가져올 때 model객체를 이용

        List<BoardDTO> boardDTOList = boardService.findAll();
        //전체 게시글 목록은 한개가 아니기 때문에 BoardDTO객체가 담겨있는 List<>를 사용

        model.addAttribute("boardList", boardDTOList);
        //가져온 데이터를 모델 객체에 담는다

        return "list";
        //list.html로 간다
        //DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다
    }
}
