package com.example.prj2.board.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.prj2.board.entity.Board}
 */
@Data
public class BoardDto implements Serializable {
    Integer id;
    String title;
    String content;
    String writer;
    LocalDateTime createdAt;
}