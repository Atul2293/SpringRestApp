package com.springboot.features.application.service.graphql.service.datafetcher;

import com.springboot.features.application.entity.Player;
import com.springboot.features.application.repository.PlayerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class AllPlayersDataFetcher implements DataFetcher<List<Player>> {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return (List<Player>)playerRepository.findAll();
    }
}
