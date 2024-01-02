package com.example.jpa_test.User;

import com.example.jpa_test.team.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)        // 지연 로딩
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Builder
    public User(String firstName, String lastName, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public void changePwd() {

    }

}