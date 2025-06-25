package com.example.prj2.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardForm {
    private String title;
    private String content;
    private String writer;
}
