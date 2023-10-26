package marcin.stenka.footballapp.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClubServiceImp implements ClubService{
    private final ClubRepository clubRepository;
    @Autowired
    public ClubServiceImp (ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }
    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club findByName(String name) {
        return clubRepository.findByName(name);
    }
    @Override
    public void addClub(Club club){
        clubRepository.save(club);
    }
}