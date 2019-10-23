package com.dkim.manager.controller;

import com.dkim.manager.model.Team;
import com.dkim.manager.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team addTeam() {
       return teamService.createTeam(new Team());
    }

    @GetMapping
    public List<Team> getAll() {
        return teamService.findAll();
    }
    @GetMapping("{id}")
    public Team getTeamById(@PathVariable("id") Team team) {
        return team;
    }
}
