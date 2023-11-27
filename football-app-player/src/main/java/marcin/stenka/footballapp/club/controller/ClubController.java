package marcin.stenka.footballapp.club.controller;

import marcin.stenka.footballapp.club.dto.PutClubRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ClubController  {
    @PutMapping("/api/clubs/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putClub(@PathVariable("id") UUID id, @RequestBody PutClubRequest request);
    @DeleteMapping("/api/clubs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClub(@PathVariable("id") UUID id);
}
