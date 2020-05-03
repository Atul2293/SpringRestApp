package com.springboot.features.application.service.graphql.service.datafetcher;

import com.springboot.features.application.entity.Team;
import com.springboot.features.application.repository.TeamRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetTeamPlayersDataFetcher implements DataFetcher<Team> {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team get(DataFetchingEnvironment dataFetchingEnvironment) {
        int teamId = dataFetchingEnvironment.getArgument("teamId");
        Optional<Team> team = teamRepository.findById((long) teamId);
        return team.orElse(null);
    }
}
