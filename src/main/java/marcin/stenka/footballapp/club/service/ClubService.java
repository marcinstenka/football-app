package marcin.stenka.footballapp.club.service;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubService {
    List<Club> findAll();
    Club findByName(String name);
    Optional<Club> findById(UUID id);
    void addClub(Club club);
    void updateClub(Club club);
    void deleteAll();
    void deleteById(UUID id);

}
