package com.example.footballmanager.dto.request;

import com.example.footballmanager.model.Team;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private Team team;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private LocalDate dateOfStartCareer;
    @NotEmpty
    private String nationality;
}
