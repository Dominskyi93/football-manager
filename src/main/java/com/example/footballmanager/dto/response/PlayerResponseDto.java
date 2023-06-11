package com.example.footballmanager.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long teamId;
    private LocalDate dateOfBirth;
    private LocalDate dateOfStartCareer;
    private String nationality;
}
