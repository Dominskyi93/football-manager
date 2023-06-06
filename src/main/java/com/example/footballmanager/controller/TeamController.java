package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.mapper.TeamMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService;
    private PlayerService playerService;
    private TeamMapper mapper;

    @PostMapping
    public TeamResponseDto add(@RequestBody TeamRequestDto dto) {
        return mapper.mapToDto(teamService.save(mapper.mapToModel(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }

    @GetMapping("/{id}")
    public TeamResponseDto get(@PathVariable Long id) {
        return mapper.mapToDto(teamService.get(id));
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id, @RequestBody TeamRequestDto dto) {
        return mapper.mapToDto(teamService.update(id, mapper.mapToModel(dto)));
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        return teamService.findAll().stream()
                .map(mapper::mapToDto)
                .toList();
    }

    @GetMapping("/transfer")
    public String transfer(@RequestParam Long playersId, @RequestParam Long fromId, @RequestParam Long toId) {
        Player player = playerService.get(playersId);
        Team from = teamService.get(fromId);
        Team to = teamService.get(toId);
        if (teamService.transfer(player, from, to)) {
            return "Transfer successful!!!";
        }
        return "Transfer failed!!!";
    }
}
