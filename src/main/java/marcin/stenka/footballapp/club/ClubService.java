package marcin.stenka.footballapp.club;

import marcin.stenka.footballapp.player.Player;

import java.util.List;

public interface ClubService {
    List<Club> getAllClubs();
    Club findByName(String name);
    void addClub(Club club);
    void deleteAll();
    void deleteByName(String name);
}
