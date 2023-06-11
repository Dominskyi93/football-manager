package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.util.List;

public interface TeamService {
    Team save(Team team);

    Team get(Long id);

    void delete(Long id);

    Team update(Long id, Team team);

    boolean transfer(Player player, Team to);

    List<Team> findAll();
}
