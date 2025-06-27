package com.example.prj2.board.service;

import com.example.prj2.board.dto.BoardDto;
import com.example.prj2.board.dto.BoardForm;
import com.example.prj2.board.dto.BoardListInfo;
import com.example.prj2.board.entity.Board;
import com.example.prj2.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> list(Integer page) {

        Page<BoardListInfo> boardPage = boardRepository
                .findAllBy(PageRequest.of(page - 1, 10, Sort.by("id").descending()));

        List<BoardListInfo> boardList = boardPage.getContent();

        Integer rightPageNumber = ((page - 1) / 10 + 1) * 10;
        Integer leftPageNumber = rightPageNumber - 9;
        rightPageNumber = Math.min(rightPageNumber, boardPage.getTotalPages());

        var result = Map.of("boardList", boardList,
                "totalPages", boardPage.getTotalPages(),
                "totalElements", boardPage.getTotalElements(),
                "rightPageNumber", rightPageNumber,
                "leftPageNumber", leftPageNumber,
                "currentPage", page);

        return result;
    }

    public Object get(Integer id) {
        Board board = boardRepository.findById(id).get();

        BoardDto dto = new BoardDto();
        dto.setId(board.getId());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());
        dto.setCreatedAt(board.getCreatedAt());


        return board;
    }

    public void remove(Integer id) {
        boardRepository.deleteById(id);

    }
}
