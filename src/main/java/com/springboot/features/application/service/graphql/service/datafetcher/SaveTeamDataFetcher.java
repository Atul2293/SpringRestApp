package com.springboot.features.application.service.graphql.service.datafetcher;

import com.springboot.features.application.entity.Team;
import com.springboot.features.application.repository.TeamRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamDataFetcher implements DataFetcher<Team> {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team get(DataFetchingEnvironment dataFetchingEnvironment) {
        String teamName = dataFetchingEnvironment.getArgument("teamName");
        Team team = new Team();
        team.setName(teamName);
        return teamRepository.save(team);
    }
}
