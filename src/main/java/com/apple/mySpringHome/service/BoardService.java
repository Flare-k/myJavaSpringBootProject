package com.apple.mySpringHome.service;

import com.apple.mySpringHome.model.Board;
import com.apple.mySpringHome.model.User;
import com.apple.mySpringHome.repository.BoardRepository;
import com.apple.mySpringHome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;  // username을 통해 id를 가져와야 하므로 UserRepository 호출

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);    // 게시글 - 유저 (N:1)
        // 게시글을 작성하고 해당 게시글이 저장될 때 user_id도 저장되게 하기 위한 작업.
        return boardRepository.save(board);
    }
}
