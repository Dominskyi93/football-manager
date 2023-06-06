package com.example.footballmanager.dto.response;

import com.example.footballmanager.model.Team;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Team team;
    private LocalDate dateOfBirth;
    private LocalDate dateOfStartCareer;
    private String nationality;
}
