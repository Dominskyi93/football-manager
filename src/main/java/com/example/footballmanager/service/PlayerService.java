package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import java.math.BigDecimal;
import java.util.List;

public interface PlayerService {
    Player save(Player player);

    Player get(Long id);

    void delete(Long id);

    Player update(Long id, Player player);

    BigDecimal transferPrice(Player player);

    List<Player> findAll();
}
