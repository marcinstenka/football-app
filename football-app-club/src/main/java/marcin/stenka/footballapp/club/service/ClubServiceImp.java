package marcin.stenka.footballapp.club.service;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.event.repository.ClubEventRepository;
import marcin.stenka.footballapp.club.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClubServiceImp implements ClubService{
    private final ClubRepository clubRepository;
    private final ClubEventRepository clubEventRepository;
    @Autowired
    public ClubServiceImp (ClubRepository clubRepository, ClubEventRepository clubEventRepository){
        this.clubRepository = clubRepository;
        this.clubEventRepository = clubEventRepository;
    }
    @Override
    public List<Club> findAll() {
        return clubRepository.findAll();
    }
    public Optional<Club> findById(UUID id) {
        return clubRepository.findById(id);
    }
    public void addClub(Club club){
        clubRepository.save(club);
        clubEventRepository.add(club);
    }
    public void updateClub(Club club){
        clubRepository.save(club);
    }
    public void deleteById(UUID id){
        if(clubRepository.findById(id).isPresent()){
            clubRepository.deleteById(id);
            clubEventRepository.delete(id);
        }
    }
}
