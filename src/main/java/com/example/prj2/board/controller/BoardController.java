package com.example.prj2.board.controller;

import com.example.prj2.board.dto.BoardForm;
import com.example.prj2.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("write")
    public String writeForm() {


        return "board/write";
    }

    @PostMapping("write")
    public String writePost(BoardForm data) {

        boardService.add(data);


        return "board/write";
    }

    @GetMapping("list")
    public String list(Model model) {

        var result = boardService.list();

        model.addAttribute("boardList", result);
        
        return "board/list";
    }
}
