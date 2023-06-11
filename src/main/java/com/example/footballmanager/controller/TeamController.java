package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.mapper.PlayerMapper;
import com.example.footballmanager.mapper.TeamMapper;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TeamController {
    private TeamService teamService;
    private PlayerService playerService;
    private TeamMapper mapper;
    private PlayerMapper playerMapper;

    @PostMapping
    public TeamResponseDto add(@Valid @RequestBody TeamRequestDto dto) {
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

    @GetMapping("/{id}/players")
    public List<PlayerResponseDto> getTeamsPlayers(@PathVariable Long id) {
        return playerService.findAllByTeamId(id).stream()
                .map(playerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
