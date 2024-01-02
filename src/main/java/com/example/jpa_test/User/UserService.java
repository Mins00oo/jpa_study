package com.example.jpa_test.User;

import com.example.jpa_test.team.Team;
import com.example.jpa_test.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public void register(UserRegisterRequest request) {
        checkDuplicateUser(request.getLastName());

        Team team = teamRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("팀이 없음"));
        User user = UserRegisterRequest.fromDto(request, team);
        userRepository.save(user);

    }

    public void checkDuplicateUser(String lastName) {
        if (userRepository.existsByLastName(lastName)) {
            throw new IllegalArgumentException("이미 존재함");
        }
    }
}
