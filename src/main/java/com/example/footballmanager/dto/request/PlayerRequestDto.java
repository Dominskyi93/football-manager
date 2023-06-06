package com.example.footballmanager.dto.request;

import com.example.footballmanager.model.Team;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private Team team;
    @NotEmpty
    private LocalDate dateOfBirth;
    @NotEmpty
    private LocalDate dateOfStartCareer;
    @NotEmpty
    private String nationality;
}
