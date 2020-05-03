package com.springboot.features.application.service.graphql.service.datafetcher;

import com.springboot.features.application.entity.Player;
import com.springboot.features.application.entity.Team;
import com.springboot.features.application.repository.PlayerRepository;
import com.springboot.features.application.repository.TeamRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllTeamDataFetcher implements DataFetcher<List<Team>> {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Team> get(DataFetchingEnvironment dataFetchingEnvironment) {

        /*List<Team> teams = new ArrayList<>();

        teamRepository.findAll().forEach(
                team -> {
                    List<Player> players = playerRepository.findByTeamId(team.getId());
                    team.setPlayers(players);
                    teams.add(team);
                });

        return teams;*/
        return (List<Team>) teamRepository.findAll();
    }
}