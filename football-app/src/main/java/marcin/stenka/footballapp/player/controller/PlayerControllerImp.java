package marcin.stenka.footballapp.player.controller;

import marcin.stenka.footballapp.player.dto.GetPlayerResponse;
import marcin.stenka.footballapp.player.dto.GetPlayersResponse;
import marcin.stenka.footballapp.player.dto.PatchPlayerRequest;
import marcin.stenka.footballapp.player.dto.PutPlayerRequest;
import marcin.stenka.footballapp.player.function.PlayerToResponseFunction;
import marcin.stenka.footballapp.player.function.PlayersToResponseFunction;
import marcin.stenka.footballapp.player.function.RequestToPlayerFunction;
import marcin.stenka.footballapp.player.function.UpdatePlayerWithRequestFunction;
import marcin.stenka.footballapp.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class PlayerControllerImp implements PlayerController {
    private final PlayerService playerService;
    private final PlayerToResponseFunction playerToResponse;
    private final PlayersToResponseFunction playersToResponse;
    private final RequestToPlayerFunction requestToPlayer;
    private final UpdatePlayerWithRequestFunction updatePlayerWithRequest;
    @Autowired
    public PlayerControllerImp(PlayerService playerService, PlayerToResponseFunction playerToResponse, PlayersToResponseFunction playersToResponse, RequestToPlayerFunction requestToPlayer, UpdatePlayerWithRequestFunction updatePlayerWithRequest) {
        this.playerService = playerService;
        this.playerToResponse = playerToResponse;
        this.playersToResponse = playersToResponse;
        this.requestToPlayer = requestToPlayer;
        this.updatePlayerWithRequest = updatePlayerWithRequest;
    }
    @Override
    public GetPlayersResponse getPlayers(){
        return playersToResponse.apply(playerService.findAll());
    }

    @Override
    public GetPlayersResponse getClubPlayers(UUID clubId) {
        return playerService.findAllByClub(clubId)
                .map(playersToResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetPlayerResponse getPlayer(UUID id) {
        return playerService.findById(id)
                .map(playerToResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putPlayer(UUID id, PutPlayerRequest request) {
        playerService.addPlayer(requestToPlayer.apply(id, request));
    }

    @Override
    public void patchPlayer(UUID id, PatchPlayerRequest request) {
        playerService.updatePlayer(updatePlayerWithRequest.apply(playerService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }

    @Override
    public void deletePlayer(UUID id) {
        playerService.findById(id)
                .ifPresentOrElse(
                        player -> playerService.deleteById(id),
                        () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
                );
    }
}
