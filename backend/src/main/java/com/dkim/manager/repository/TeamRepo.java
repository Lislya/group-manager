package com.dkim.manager.repository;

import com.dkim.manager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
