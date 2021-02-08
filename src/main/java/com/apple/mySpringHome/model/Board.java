package com.apple.mySpringHome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // 모델 클래스임을 나타내기 위해 Entity 어노테이션추가
@Data   // Lombok을 통해 멤버변수들을 외부에서 사용할 수 있다. (Getter, Setter)
public class Board {
    @Id //id가 pk임을 알리기 위해 어노테이션 추가
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;
    /**
     * [Validating Form Input]
     * 사용자가 잘못된 값을 입력할 수도 있고
     * 고의적으로 해킹을 시도하기 위해서 잘못된 데이터를 전송할 수도 있다.
     * 서버에서는 클라이언트가 보내준 데이터를 믿지말고 제대로 전송했는지 체크하는 작업이 필수적이다.
     */
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자 이상, 30자 이하입니다.")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")    // name은 Board에 있는 컬럼명, referencedColumnName는 매핑되는 User 테이블의 컬럼
    private User user;
}


/**
 * 이러한 Model을 사용하기 위해 Repository를 생성한다.
 */