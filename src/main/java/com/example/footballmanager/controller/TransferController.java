package com.example.footballmanager.controller;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TransferController {
    private TeamService teamService;
    private PlayerService playerService;

    @PostMapping
    public String transfer(@RequestParam Long playerId, @RequestParam Long teamId) {
        Player player = playerService.get(playerId);
        Team team = teamService.get(teamId);
        if (teamService.transfer(player, team)) {
            return "Transfer successful!!!";
        }
        return "Transfer failed!!!";
    }
}
