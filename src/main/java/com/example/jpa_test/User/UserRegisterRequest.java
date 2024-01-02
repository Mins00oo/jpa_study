package com.example.jpa_test.User;

import com.example.jpa_test.team.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterRequest {
    private String fistName;

    private String lastName;

    @Builder
    public UserRegisterRequest(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public static User fromDto(
            UserRegisterRequest request,
            Team team
    ) {
        return User.builder()
                .firstName(request.getFistName())
                .lastName(request.getLastName())
                .team(team)
                .build();
    }
}
