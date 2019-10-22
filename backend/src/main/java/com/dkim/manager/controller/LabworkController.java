package com.dkim.manager.controller;

import com.dkim.manager.model.Labwork;
import com.dkim.manager.repository.LabworkRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/labwork")
public class LabworkController {
    private final LabworkRepo labworkRepo;

    @Autowired
    public LabworkController(LabworkRepo labworkRepo) {
        this.labworkRepo = labworkRepo;
    }

    @PostMapping
    public Labwork addLabwork(@RequestBody Labwork labwork) {
        return labworkRepo.save(labwork);
    }

    @GetMapping
    public List<Labwork> getAllLabworks() {
        return labworkRepo.findAll();
    }

    @PutMapping("{id}")
    public Labwork updateLabwork(
            @PathVariable("id") Labwork labworkFromDb,
            @RequestBody Labwork labworkFromUser
    ) {
        BeanUtils.copyProperties(labworkFromUser, labworkFromDb);
        return labworkRepo.save(labworkFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteLabwork(@PathVariable("id") Labwork labwork) {
        labworkRepo.delete(labwork);
    }
}
