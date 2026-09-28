package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.News;
import com.soul.esportsteam.repository.NewsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    private final NewsRepository repository;

    public NewsController(NewsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<News> getNews() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public News addNews(@RequestBody News news) {
        return repository.save(news);
    }

    @PutMapping("/{id}")
    public News updateNews(
            @PathVariable Long id,
            @RequestBody News news) {

        News existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setTitle(news.getTitle());
        existing.setDescription(news.getDescription());
        existing.setImage(news.getImage());
        existing.setPublishedDate(news.getPublishedDate());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        repository.deleteById(id);
    }
}