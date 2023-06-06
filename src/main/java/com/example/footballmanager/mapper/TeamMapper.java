package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TeamMapper {
    private PlayerService playerService;

    public Team mapToModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setTitle(dto.getTitle());
        team.setCountry(dto.getCountry());
        team.setCity(dto.getCity());
        team.setBalance(dto.getBalance());
        team.setCommission(dto.getCommission());
        Set<Player> players = dto.getPlayerIds().stream()
                .map(id -> playerService.get(id))
                .collect(Collectors.toSet());
        team.setPlayers(players);
        return team;
    }

    public TeamResponseDto mapToDto(Team team) {
        TeamResponseDto dto = new TeamResponseDto();
        dto.setId(team.getId());
        dto.setCountry(team.getCountry());
        dto.setCity(team.getCity());
        dto.setTitle(team.getTitle());
        dto.setBalance(team.getBalance());
        dto.setCommission(team.getCommission());
        List<Long> playerIds = team.getPlayers().stream()
                .map(Player::getId)
                .toList();
        dto.setPlayerIds(playerIds);
        return dto;
    }
}
