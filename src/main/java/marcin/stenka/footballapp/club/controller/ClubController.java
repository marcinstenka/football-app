package marcin.stenka.footballapp.club.controller;

import marcin.stenka.footballapp.club.dto.GetClubResponse;
import marcin.stenka.footballapp.club.dto.GetClubsResponse;
import marcin.stenka.footballapp.club.dto.PutClubRequest;
import marcin.stenka.footballapp.club.dto.PatchClubRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ClubController  {
    @GetMapping("api/clubs")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClubsResponse getClubs();

    @GetMapping("api/clubs/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClubResponse getClub(@PathVariable("id") UUID id);

    @PutMapping("/api/clubs/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putClub(@PathVariable("id") UUID id, @RequestBody PutClubRequest request);

    @PatchMapping("/api/clubs/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void patchClub(@PathVariable("id") UUID id, @RequestBody PatchClubRequest request);

    @DeleteMapping("/api/clubs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClub(@PathVariable("id") UUID id);
}
