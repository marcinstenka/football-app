package marcin.stenka.footballapp.club.service;

<<<<<<< HEAD:src/main/java/marcin/stenka/footballapp/club/service/ClubServiceImp.java
import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.ClubRepository;
=======
import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.repository.ClubRepository;
>>>>>>> a40d5a81c96a195a86cf47643aec34e534e170d7:football-app/src/main/java/marcin/stenka/footballapp/club/service/ClubServiceImp.java
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
