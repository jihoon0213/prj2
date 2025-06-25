package com.example.prj2.board.service;

import com.example.prj2.board.dto.BoardForm;
import com.example.prj2.board.entity.Board;
import com.example.prj2.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;


    public void add(BoardForm data) {

        Board board = new Board();
        board.setTitle(data.getTitle());
        board.setContent(data.getContent());
        board.setWriter(data.getWriter());

        boardRepository.save(board);

    }

    public Object list() {

        List<Board> list = boardRepository.findAll();

        return list;
    }
}
