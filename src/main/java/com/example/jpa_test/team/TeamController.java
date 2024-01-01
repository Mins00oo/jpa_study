package com.example.jpa_test.team;

import com.example.jpa_test.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/team/users/{teamId}")
    public ResponseEntity<Object> getTeamUsers(@PathVariable Long teamId) {
        List<Team> users = teamService.getUsersByTeam(teamId);
        return ResponseEntity.ok(users);
    }
}
