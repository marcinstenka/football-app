package marcin.stenka.footballapp.club.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ClubController  {
    @DeleteMapping("/api/clubs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClub(@PathVariable("id") UUID id);
}
