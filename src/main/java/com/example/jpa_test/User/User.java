package com.example.jpa_test.User;

import com.example.jpa_test.team.Team;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)		// 즉시 로딩
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}