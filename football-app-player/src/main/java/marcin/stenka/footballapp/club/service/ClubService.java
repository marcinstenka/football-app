package marcin.stenka.footballapp.club.service;

import marcin.stenka.footballapp.club.entity.Club;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubService {
    List<Club> findAll();
    Optional<Club> findById(UUID id);
    void addClub(Club club);
    void updateClub(Club club);
    void deleteById(UUID id);

}
