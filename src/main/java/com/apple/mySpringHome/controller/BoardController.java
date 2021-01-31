package com.apple.mySpringHome.controller;

import com.apple.mySpringHome.model.Board;
import com.apple.mySpringHome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")   // 경로 지정
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {  // 게시판을 호출할 때 데이터 값을 넘겨주고 싶다.. 파라미터로 Model을 가져온다.
        /**
         *  model에 원하는 값을 넘겨준다.
         *  Board Repo를 이용하여 테이블 내에 있는 값을 가져온다.
         *  그러기 위해서 boardRepository 객체 생성
         */
        List<Board> boards = boardRepository.findAll(); // Board Repo에서 값을 가져와 boards에 할당
        model.addAttribute("boards", boards);   //키, 밸류
        // model에 담긴 데이터들은 thymeleaf에서 사용할 수 있게된다.

        return "board/list";
    }
    
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("board", new Board());   // thymeleaf로 board 키를 사용해 내용을 저장해놓을 것
        // board를 작성하여 Post할 것이기 때문에 new Board()를 미리 생성해준다.
        return "board/form";
    }

    @PostMapping("/form")
    public String postForm(@ModelAttribute Board board) {
        boardRepository.save(board);
        return "redirect:/board/list";
        // redirect를 해야 list에 대한 내용으로 다시 값이 뿌려지는 쿼리가 실행된다
    }
}
