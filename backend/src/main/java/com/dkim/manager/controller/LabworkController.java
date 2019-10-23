package com.dkim.manager.controller;

import com.dkim.manager.model.Labwork;
import com.dkim.manager.service.LabworkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/labwork")
public class LabworkController {
    private final LabworkService labworkService;

    @Autowired
    public LabworkController(LabworkService labworkService) {
        this.labworkService = labworkService;
    }

    @PostMapping
    public Labwork addLabwork(@RequestBody Labwork labwork) {
        return labworkService.addLabwork(labwork);
    }

    @GetMapping
    public List<Labwork> getAllLabworks() {
        return labworkService.getAllLabworks();
    }

    @PutMapping("{id}")
    public Labwork updateLabwork(
            @PathVariable("id") Labwork labworkFromDb,
            @RequestBody Labwork labworkFromUser
    ) {
        BeanUtils.copyProperties(labworkFromUser, labworkFromDb);
        return labworkService.addLabwork(labworkFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteLabwork(@PathVariable("id") Labwork labwork) {
        labworkService.deleteLabwork(labwork);
    }
}
