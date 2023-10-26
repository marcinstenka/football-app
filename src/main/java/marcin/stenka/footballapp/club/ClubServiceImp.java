package marcin.stenka.footballapp.club;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClubServiceImp implements ClubService{
    private final ClubRepository clubRepository;
    private final PlayerService playerService;
    @Autowired
    public ClubServiceImp (ClubRepository clubRepository, PlayerService playerService){
        this.clubRepository = clubRepository;
        this.playerService = playerService;
    }
    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club findByName(String name) {
        return clubRepository.findByName(name);
    }

    public void addClub(Club club){
        clubRepository.save(club);
    }

    public void deleteAll() {
        clubRepository.deleteAll();
    }
    public void deleteByName(String name){
        Club club = clubRepository.findByName(name);
        if (club != null){
            List<Player> players = playerService.getAllPlayers(club);
            for (Player player: players) {
                playerService.deleteClubFromPlayer(player);
            }
            clubRepository.delete(club);
            System.out.println("Deleted");
        } else{
            System.out.println("There is no '"+ name+"' club in th database. Not deleted");
        }
    }
}
