package com.dkim.manager.service;

import com.dkim.manager.model.Team;
import com.dkim.manager.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public Team findById(Long id) {
        return teamRepo.findById(id).orElse(null);
    }

    public List<Team> findAll() {
        return teamRepo.findAll();
    }
    public Team createTeam(Team team) {
        return teamRepo.save(team);
    }

    public void delete(Team team) {
        teamRepo.delete(team);
    }
}
