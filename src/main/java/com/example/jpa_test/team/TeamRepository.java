package com.example.jpa_test.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // Fetch Join을 사용한 쿼리
    @Query("SELECT t FROM Team t JOIN FETCH t.users")
    List<Team> findAllWithUsers();
}
