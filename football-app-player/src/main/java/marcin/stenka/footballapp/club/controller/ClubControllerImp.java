package marcin.stenka.footballapp.club.controller;

import marcin.stenka.footballapp.club.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class ClubControllerImp implements ClubController{
    private final ClubService clubService;

    @Autowired
    public ClubControllerImp(ClubService clubService){
        this.clubService = clubService;

    }
    @Override
    public void deleteClub(UUID id) {
        clubService.findById(id).ifPresentOrElse(
                club -> clubService.deleteById(id), () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );

    }
}
