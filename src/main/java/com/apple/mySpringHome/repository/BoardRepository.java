package com.apple.mySpringHome.repository;

import com.apple.mySpringHome.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}