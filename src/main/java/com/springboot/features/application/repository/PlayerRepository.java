package com.springboot.features.application.repository;

import com.springboot.features.application.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByTeamId(long teamId);
}
