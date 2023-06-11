package com.example.footballmanager.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotEmpty
    @Size(min = 3, max = 18)
    private String title;
    @Size(min = 3, max = 18)
    @NotEmpty
    private String city;
    @Size(min = 2, max = 18)
    @NotEmpty
    private String country;
    @Min(0)
    private BigDecimal balance;
    @Min(0)
    @Max(10)
    private BigDecimal commission;
}
