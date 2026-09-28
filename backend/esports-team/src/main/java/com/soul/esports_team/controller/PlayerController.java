package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.Player;
import com.soul.esportsteam.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return repository.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player) {

        Player existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setPlayerName(player.getPlayerName());
        existing.setRealName(player.getRealName());
        existing.setRole(player.getRole());
        existing.setImage(player.getImage());
        existing.setInstagram(player.getInstagram());
        existing.setYoutube(player.getYoutube());
        existing.setTwitter(player.getTwitter());
        existing.setStatus(player.getStatus());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}