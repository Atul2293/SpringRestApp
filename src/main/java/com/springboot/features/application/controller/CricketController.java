package com.springboot.features.application.controller;

import com.springboot.features.application.service.CricketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cricket")
@Api(value="Cricket", description="Cricket Related API's")
public class CricketController {

    @Autowired
    private CricketService cricketService;

    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @ApiOperation(value = "get all players name by team id",
            responseContainer = "List",
            response = String.class)
    @GetMapping("/get_team_players/{team_id}")
    public List<String> getAllTeamPlayers(@PathVariable("team_id") Long teamId ){
        return cricketService.getAllTeamPlayers(teamId);
    }

    @ApiOperation(value = "Add New player in indian team", response = void.class)
    @PostMapping("/add_indian_player")
    public void addIndianPlayer(@RequestParam("name")String name,
                                @RequestParam("position")String position,
                                @RequestParam("number")int no){
        cricketService.addIndianPlayer(name,position,no);
    }
}
