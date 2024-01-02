package com.example.jpa_test.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // Fetch Join을 사용한 쿼리
}
