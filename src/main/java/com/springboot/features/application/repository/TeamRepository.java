package com.springboot.features.application.repository;

import com.springboot.features.application.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByPlayers(long playerId);
}
