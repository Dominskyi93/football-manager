package com.example.footballmanager.dto.response;

import com.example.footballmanager.model.Player;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String title;
    private String country;
    private String city;
    private List<Long> playerIds;
    private BigDecimal balance;
    private BigDecimal commission;
}
