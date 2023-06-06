package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private PlayerService playerService;

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team get(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("A team with this id doesn't exist!!!"));
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team update(Long id, Team team) {
        Team referenceById = teamRepository.getReferenceById(id);
        team.setId(referenceById.getId());
        return teamRepository.save(team);
    }

    @Override
    @Transactional
    public boolean transfer(Player player, Team from, Team to) {
        if (!from.getPlayers().contains(player)) {
            throw new RuntimeException("The team doesn't have such player!");
        }
        BigDecimal transferPrice = playerService.transferPrice(player);
        BigDecimal commission = transferPrice.divide(BigDecimal.valueOf(100)
                .multiply(from.getCommission()));
        BigDecimal priceWithCommission = transferPrice.add(commission);
        if (to.getBalance().compareTo(priceWithCommission) < 0) {
            throw new RuntimeException("Not enough balance!!!");
        }
        to.setBalance(to.getBalance().subtract(priceWithCommission));
        from.setBalance(from.getBalance().add(priceWithCommission));
        from.getPlayers().remove(player);
        to.getPlayers().add(player);
        return true;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
