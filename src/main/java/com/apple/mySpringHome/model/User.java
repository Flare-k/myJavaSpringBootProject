package com.apple.mySpringHome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}
