package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.Media;
import com.soul.esportsteam.repository.MediaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@CrossOrigin(origins = "*")
public class MediaController {

    private final MediaRepository repository;

    public MediaController(MediaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Media> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Media add(@RequestBody Media media) {
        return repository.save(media);
    }

    @PutMapping("/{id}")
    public Media update(
            @PathVariable Long id,
            @RequestBody Media media) {

        Media existing =
                repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setTitle(media.getTitle());
        existing.setVideoUrl(media.getVideoUrl());
        existing.setDescription(media.getDescription());
        existing.setCategory(media.getCategory());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}