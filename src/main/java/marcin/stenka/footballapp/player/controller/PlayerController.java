package marcin.stenka.footballapp.player.controller;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    @GetMapping("/players/{surname}")
    public Player findBySurname(@PathVariable String surname) {
        return playerService.findBySurname(surname);
    }
    @PostMapping("/players")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }
}

