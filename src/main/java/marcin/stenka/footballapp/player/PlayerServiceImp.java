package marcin.stenka.footballapp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerServiceImp implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public Player findBySurname(String surname) {
        return playerRepository.findBySurname(surname);
    }
    @Override
    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    @Override
    public void deleteAll() {
        playerRepository.deleteAll();
    }
}
