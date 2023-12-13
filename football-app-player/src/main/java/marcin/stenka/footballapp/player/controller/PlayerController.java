package marcin.stenka.footballapp.player.controller;


import marcin.stenka.footballapp.player.dto.GetPlayerResponse;
import marcin.stenka.footballapp.player.dto.GetPlayersResponse;
import marcin.stenka.footballapp.player.dto.PatchPlayerRequest;
import marcin.stenka.footballapp.player.dto.PutPlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface PlayerController {
    @GetMapping("/api/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers();

    @GetMapping("/api/clubs/{clubId}/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getClubPlayers(@PathVariable("clubId")UUID clubId);

    @GetMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(@PathVariable("id") UUID id);

    @PutMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPlayer(@PathVariable("id") UUID id, @RequestBody PutPlayerRequest request);

    @PatchMapping("/api/players/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    void patchPlayer( @PathVariable("id") UUID id, @RequestBody PatchPlayerRequest request);

    @DeleteMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlayer(@PathVariable("id") UUID id);
}

