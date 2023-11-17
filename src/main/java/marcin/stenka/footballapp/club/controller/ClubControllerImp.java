package marcin.stenka.footballapp.club.controller;

import marcin.stenka.footballapp.club.service.ClubService;
import marcin.stenka.footballapp.club.dto.GetClubResponse;
import marcin.stenka.footballapp.club.dto.GetClubsResponse;
import marcin.stenka.footballapp.club.dto.PutClubRequest;
import marcin.stenka.footballapp.club.function.ClubToResponseFunction;
import marcin.stenka.footballapp.club.function.ClubsToResponseFunction;
import marcin.stenka.footballapp.club.function.RequestToClubFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class ClubControllerImp implements ClubController{
    private final ClubService clubService;
    private final ClubToResponseFunction clubToResponse;
    private final ClubsToResponseFunction clubsToResponse;
    private final RequestToClubFunction requestToClub;

    @Autowired
    public ClubControllerImp(ClubService clubService, ClubToResponseFunction clubToResponse, ClubsToResponseFunction clubsToResponse, RequestToClubFunction requestToClub){
        this.clubService = clubService;
        this.clubToResponse = clubToResponse;
        this.clubsToResponse = clubsToResponse;
        this.requestToClub = requestToClub;
    }

    @Override
    public GetClubsResponse getClubs() {
        return clubsToResponse.apply(clubService.findAll());
    }

    @Override
    public GetClubResponse getClub(UUID id) {
        return clubService.findById(id)
                .map(clubToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putClub(UUID id, PutClubRequest request) {
        clubService.addClub(requestToClub.apply(id, request));
    }

    @Override
    public void deleteClub(UUID id) {
        clubService.findById(id).ifPresentOrElse(
                club -> clubService.deleteById(id), () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );

    }
}
