package com.apple.mySpringHome.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 모델 클래스임을 나타내기 위해 Entity 어노테이션추가
@Data   // Lombok을 통해 멤버변수들을 외부에서 사용할 수 있다. (Getter, Setter)
public class Board {
    @Id //id가 pk임을 알리기 위해 어노테이션 추가
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;
    private String title;
    private String content;
}


/**
 * 이러한 Model을 사용하기 위해 Repository를 생성한다.
 */