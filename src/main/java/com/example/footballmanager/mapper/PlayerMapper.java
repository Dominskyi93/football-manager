package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public Player mapToModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setDateOfBirth(dto.getDateOfBirth());
        player.setDateOfStartCareer(dto.getDateOfStartCareer());
        player.setNationality(dto.getNationality());
        return player;
    }

    public PlayerResponseDto mapToDto(Player player) {
        PlayerResponseDto dto = new PlayerResponseDto();
        dto.setId(player.getId());
        dto.setTeam(player.getTeam());
        dto.setNationality(player.getNationality());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setDateOfBirth(player.getDateOfBirth());
        dto.setDateOfStartCareer(player.getDateOfStartCareer());
        return dto;
    }
}
