package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TeamMapper {

    public Team mapToModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setTitle(dto.getTitle());
        team.setCountry(dto.getCountry());
        team.setCity(dto.getCity());
        team.setBalance(dto.getBalance());
        team.setCommission(dto.getCommission());
        Set<Player> players = Collections.emptySet();
        team.setPlayers(players);
        return team;
    }

    public TeamResponseDto mapToDto(Team team) {
        TeamResponseDto dto = new TeamResponseDto();
        dto.setId(team.getId());
        dto.setTitle(team.getTitle());
        dto.setCountry(team.getCountry());
        dto.setCity(team.getCity());
        dto.setBalance(team.getBalance());
        dto.setCommission(team.getCommission());
        List<Long> playerIds = new ArrayList<>();
        dto.setPlayerIds(playerIds);
        return dto;
    }
}
