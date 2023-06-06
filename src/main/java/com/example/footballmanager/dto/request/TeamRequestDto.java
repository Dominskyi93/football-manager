package com.example.footballmanager.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotEmpty
    private String title;
    @Size(min = 2, max = 18)
    private String country;
    @Size(min = 3, max = 18)
    private String city;
    private List<Long> playerIds;
    @Min(0)
    private BigDecimal balance;
    @Min(0)
    @Max(10)
    private BigDecimal commission;
}
