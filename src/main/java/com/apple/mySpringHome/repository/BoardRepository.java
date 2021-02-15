package com.apple.mySpringHome.repository;

import com.apple.mySpringHome.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository를 상속받아 메소드를 사용
    List<Board> findByTitle(String title);  // 인터페이스만 정의하면 구현은 알아서 된다.
    List<Board> findByTitleOrContent(String title, String content);

    Page<Board> findByTitleOrContentContaining(String title, String content, Pageable pageable);
}
