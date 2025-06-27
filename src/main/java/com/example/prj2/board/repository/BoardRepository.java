package com.example.prj2.board.repository;

import com.example.prj2.board.dto.BoardListInfo;
import com.example.prj2.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<BoardListInfo> findAllBy(Pageable pageable);
}