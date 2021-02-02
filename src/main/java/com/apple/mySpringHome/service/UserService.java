package com.apple.mySpringHome.service;

import com.apple.mySpringHome.model.Role;
import com.apple.mySpringHome.model.User;
import com.apple.mySpringHome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Service 클래스를 이용해서 Test를 작성하기도 유용하다.

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;    //비밀번호 암호화

    public User save(User user) {
        /**
         * 여기서 그냥 저장하면 안 될것이다.
         * 그냥 저장하다면 사용자 이름과 비밀번호만 저장하는 꼴..
         */

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);  // 회원가입하면 활성화로 표시

        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);  // role을 어떤 권한을 줄 것인지 저장한다. user_role 테이블에 role_id가 저장된다.

        return userRepository.save(user);
    }
}
