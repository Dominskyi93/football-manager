package com.example.footballmanager;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.repository.PlayerRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FootballManagerApplication {


    public static void main(String[] args) {

        PlayerRepository playerRepository;
        List<TeamRequestDto> teams = new ArrayList<>();

        // Команда 1
        TeamRequestDto team1 = new TeamRequestDto();
        team1.setTitle("Real Madrid");
        team1.setCountry("Spain");
        team1.setCity("Madrid");
        team1.setPlayerIds(new ArrayList<>());
        team1.setBalance(BigDecimal.valueOf(1000000));
        team1.setCommission(BigDecimal.valueOf(5));
        teams.add(team1);

        // Команда 2
        TeamRequestDto team2 = new TeamRequestDto();
        team2.setTitle("FC Barcelona");
        team2.setCountry("Spain");
        team2.setCity("Barcelona");
        team2.setPlayerIds(new ArrayList<>());
        team2.setBalance(BigDecimal.valueOf(800000));
        team2.setCommission(BigDecimal.valueOf(6));
        teams.add(team2);

        // Команда 3
        TeamRequestDto team3 = new TeamRequestDto();
        team3.setTitle("Manchester United");
        team3.setCountry("England");
        team3.setCity("Manchester");
        team3.setPlayerIds(new ArrayList<>());
        team3.setBalance(BigDecimal.valueOf(900000));
        team3.setCommission(BigDecimal.valueOf(7));
        teams.add(team3);

        // Команда 4
        TeamRequestDto team4 = new TeamRequestDto();
        team4.setTitle("Juventus");
        team4.setCountry("Italy");
        team4.setCity("Turin");
        team4.setPlayerIds(new ArrayList<>());
        team4.setBalance(BigDecimal.valueOf(750000));
        team4.setCommission(BigDecimal.valueOf(5));
        teams.add(team4);

        // Команда 5
        TeamRequestDto team5 = new TeamRequestDto();
        team5.setTitle("Paris Saint-Germain");
        team5.setCountry("France");
        team5.setCity("Paris");
        team5.setPlayerIds(new ArrayList<>());
        team5.setBalance(BigDecimal.valueOf(1100000));
        team5.setCommission(BigDecimal.valueOf(8));
        teams.add(team5);

        // Команда 6
        TeamRequestDto team6 = new TeamRequestDto();
        team6.setTitle("Bayern Munich");
        team6.setCountry("Germany");
        team6.setCity("Munich");
        team6.setPlayerIds(new ArrayList<>());
        team6.setBalance(BigDecimal.valueOf(950000));
        team6.setCommission(BigDecimal.valueOf(6));
        teams.add(team6);

        // Команда 7
        TeamRequestDto team7 = new TeamRequestDto();
        team7.setTitle("Liverpool");
        team7.setCountry("England");
        team7.setCity("Liverpool");
        team7.setPlayerIds(new ArrayList<>());
        team7.setBalance(BigDecimal.valueOf(820000));
        team7.setCommission(BigDecimal.valueOf(5));
        teams.add(team7);

        // Команда 8
        TeamRequestDto team8 = new TeamRequestDto();
        team8.setTitle("AC Milan");
        team8.setCountry("Italy");
        team8.setCity("Milan");
        team8.setPlayerIds(new ArrayList<>());
        team8.setBalance(BigDecimal.valueOf(680000));
        team8.setCommission(BigDecimal.valueOf(4));
        teams.add(team8);

        // Команда 9
        TeamRequestDto team9 = new TeamRequestDto();
        team9.setTitle("Chelsea");
        team9.setCountry("England");
        team9.setCity("London");
        team9.setPlayerIds(new ArrayList<>());
        team9.setBalance(BigDecimal.valueOf(1000000));
        team9.setCommission(BigDecimal.valueOf(6));
        teams.add(team9);

        // Команда 10
        TeamRequestDto team10 = new TeamRequestDto();
        team10.setTitle("Ajax");
        team10.setCountry("Netherlands");
        team10.setCity("Amsterdam");
        team10.setPlayerIds(new ArrayList<>());
        team10.setBalance(BigDecimal.valueOf(580000));
        team10.setCommission(BigDecimal.valueOf(3));
        teams.add(team10);
        SpringApplication.run(FootballManagerApplication.class, args);


    }


}
