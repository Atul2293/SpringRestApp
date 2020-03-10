package com.springboot.features.application.service;

import java.util.List;

public interface CricketService {
    public List<String> getAllTeamPlayers(long teamId);
    public void addIndianPlayer(String name, String position, int number);
}
