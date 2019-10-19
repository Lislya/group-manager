package com.dkim.manager.repository;

import com.dkim.manager.model.Labwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabworkRepo extends JpaRepository<Labwork, Long> {
}
