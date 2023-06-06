package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private static final long PRICE_PER_MONTH = 100000L;

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player get(Long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("A player with this id doesn't exist!!!"));
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player update(Long id, Player player) {
        Player referenceById = playerRepository.getReferenceById(id);
        player.setId(referenceById.getId());
        return playerRepository.save(player);
    }

    @Override
    public BigDecimal transferPrice(Player player) {
        long experience = ChronoUnit.MONTHS.between(player.getDateOfStartCareer(), LocalDate.now());
        long age = ChronoUnit.YEARS.between(player.getDateOfBirth(), LocalDate.now());
        return BigDecimal.valueOf(experience * PRICE_PER_MONTH / age);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
