package marcin.stenka.footballapp.player.service;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.player.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    List<Player> getAllPlayers(Club club);
    Player findBySurname(String surname);
    void deleteClubFromPlayer(Player player);
    void addPlayer(Player player);

    void deleteAll();
    void deleteBySurname(String surname);
    void changePlayerClub(String surname, Club club);
}
