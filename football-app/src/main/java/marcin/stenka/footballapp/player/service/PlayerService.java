package marcin.stenka.footballapp.player.service;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.player.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {
    List<Player> findAll();
    Optional<List<Player>> findAllByClub(UUID clubId);
    Optional<Player> findById(UUID id);
    Player findBySurname(String surname);
    void deleteClubFromPlayer(Player player);
    void addPlayer(Player player);
    void updatePlayer(Player player);
    void deleteAll();
    void deleteBySurname(String surname);
    void deleteById(UUID id);
    void changePlayerClub(String surname, Club club);

}
