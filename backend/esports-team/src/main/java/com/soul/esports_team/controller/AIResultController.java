package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.AIResult;
import com.soul.esportsteam.repository.AIResultRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai-results")
@CrossOrigin(origins = "*")
public class AIResultController {

    private final AIResultRepository repository;

    public AIResultController(AIResultRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AIResult> getAllResults() {
        return repository.findAll();
    }

    @PostMapping
    public AIResult saveResult(@RequestBody AIResult result) {
        return repository.save(result);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        repository.deleteById(id);
    }
}