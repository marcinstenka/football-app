package marcin.stenka.footballapp.club.service;

<<<<<<< HEAD:src/main/java/marcin/stenka/footballapp/club/ClubServiceImp.java
import jakarta.transaction.Transactional;
=======
import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.ClubRepository;
>>>>>>> aa150c01edb0796bff6158c6c0892089e8bfeff9:src/main/java/marcin/stenka/footballapp/club/service/ClubServiceImp.java
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<Club> findAll() {
        return clubRepository.findAll();
    }
    @Transactional
    public Club findByName(String name) {
        return clubRepository.findByName(name);
    }
    public Optional<Club> findById(UUID id) {
        return clubRepository.findById(id);
    }

    public void addClub(Club club){
        clubRepository.save(club);
    }
    public void updateClub(Club club){
        clubRepository.save(club);
    }

    public void deleteAll() {
        clubRepository.deleteAll();
    }

    public void deleteById(UUID id){
        if(clubRepository.findById(id).isPresent()){
            clubRepository.deleteById(id);
        }
    }
}
