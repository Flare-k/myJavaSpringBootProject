package com.apple.mySpringHome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class User {
    @Id //id가 pk임을 알리기 위해 어노테이션 추가
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    // Many-to-Many Mapping
    @ManyToMany
    @JoinTable( // 내가 만든 조인 테이블
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles = new ArrayList<>();   // 기본값이 NULL이 되게되면 불필요하게 Nullptr Exception이 자주 발생하기 때문에 생성시 ArrayList에 채우는 방향으로..
    //User Repo를 이용해서 조회하게 되면 User에 해당하는 권한이 알아서 조회가 되서 roles에 담기게 된다.

    // User 입장에서 Board는 OneToMany 관계이다.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)   // Board에서는 JoinColumn을 사용했는데 여기서는 Board에서 User를 생성한 변수명 'user'를 mappedBy로 불러온다. 이렇게 되면 서로 조회하는 양방향 Mapping이 된다.
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();
    /**
     * 보통 양방향 Mapping 할 때, ManyToOne에서 JoinColumn을 작성하고.. OneToMany에서는  mappedBy 키워드를 이용한다.
     */
}
