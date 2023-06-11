package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.mapper.PlayerMapper;
import com.example.footballmanager.service.PlayerService;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PlayerController {
    private PlayerService playerService;
    private PlayerMapper mapper;

    @PostMapping
    public PlayerResponseDto add(@Valid @RequestBody PlayerRequestDto dto) {
        return mapper.mapToDto(playerService.save(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return mapper.mapToDto(playerService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id, @RequestBody PlayerRequestDto dto) {
        return mapper.mapToDto(playerService.update(id, mapper.mapToModel(dto)));
    }

    @GetMapping
    public List<PlayerResponseDto> getAll() {
        return playerService.findAll().stream()
                .map(mapper::mapToDto)
                .toList();
    }
}
