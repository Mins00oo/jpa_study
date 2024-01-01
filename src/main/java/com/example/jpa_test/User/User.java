package com.example.jpa_test.User;

import com.example.jpa_test.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)        // 지연 로딩
    @JoinColumn(name = "team_id", nullable = false)
    @JsonBackReference
    private Team team;
}