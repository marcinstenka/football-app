package marcin.stenka.footballapp.player;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImp implements PlayerService{
    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getAllPlayers(Club playersClub) {
        return playersClub.getPlayers();
    }

    public Player findBySurname(String surname) {
        return playerRepository.findBySurname(surname);
    }


    public void deleteClubFromPlayer(Player player) {
        player.setClub(null);
        playerRepository.save(player);
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }


    public void deleteAll() {
        playerRepository.deleteAll();
    }

    public void deleteBySurname(String surname) {
        Player player = playerRepository.findBySurname(surname);
        playerRepository.delete(player);
    }

    public void changePlayerClub(String surname, Club club) {
        Player player = playerRepository.findBySurname(surname);
        player.setClub(club);
        playerRepository.save(player);
    }
}
