package marcin.stenka.footballapp.player;

import marcin.stenka.footballapp.club.Club;

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
