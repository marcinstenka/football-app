package marcin.stenka.footballapp.player.service;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.repository.ClubRepository;
import marcin.stenka.footballapp.player.entity.Player;
import marcin.stenka.footballapp.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImp implements PlayerService{
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<List<Player>> findAllByClub(UUID clubId) {
        return clubRepository.findById(clubId)
                .map(playerRepository::findAllByClub);
    }
    public Optional <Player> findById(UUID id){
        return playerRepository.findById(id);
    }
    public void addPlayer(Player player){
        playerRepository.save(player);
    }
    public void updatePlayer(Player player){ playerRepository.save(player);}
    public void deleteById(UUID id){
        if (playerRepository.findById(id).isPresent()){
            playerRepository.deleteById(id);
        }
    }
}
