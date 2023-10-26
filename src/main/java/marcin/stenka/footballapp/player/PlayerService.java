package marcin.stenka.footballapp.player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    Player findBySurname(String surname);
    void addPlayer(Player player);
    void deleteAll();
}
