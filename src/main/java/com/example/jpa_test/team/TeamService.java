package com.example.jpa_test.team;

import com.example.jpa_test.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Team> getUsersByTeam(Long teamId) {
        List<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            team.getUsers().size();
        }
        return teams;
    }
}
