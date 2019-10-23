package com.dkim.manager.service;

import com.dkim.manager.model.Labwork;
import com.dkim.manager.repository.LabworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabworkService {
    private final LabworkRepo labworkRepo;

    @Autowired
    public LabworkService(LabworkRepo labworkRepo) {
        this.labworkRepo = labworkRepo;
    }

    public Labwork addLabwork(Labwork labwork) {
        return labworkRepo.save(labwork);
    }

    public List<Labwork> getAllLabworks() {
        return labworkRepo.findAll();
    }

    public void deleteLabwork(Labwork labwork) {
        labworkRepo.delete(labwork);
    }
}
