package com.springboot.features.application.service;

import com.springboot.features.application.entity.Player;
import com.springboot.features.application.entity.Team;
import com.springboot.features.application.repository.PlayerRepository;
import com.springboot.features.application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CricketServiceImpl implements CricketService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<String> getAllTeamPlayers(long teamId) {
        List<Player> players = playerRepository.findByTeamId(teamId);
        return players.stream().map(p -> p.getName()).collect(Collectors.toList());
    }

    @Override
    public void addIndianPlayer(String name, String position, int number) {
        if(teamRepository.findById(1l).isPresent()){
            Team india = teamRepository.findById(1l).get();
            Player newPlayer = new Player();
            newPlayer.setName(name);
            newPlayer.setPosition(position);
            newPlayer.setNum(number);
            newPlayer.setTeam(india);
            playerRepository.save(newPlayer);
        }
    }
}
