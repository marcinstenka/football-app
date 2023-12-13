package marcin.stenka.footballapp.club.event.repository;

import marcin.stenka.footballapp.club.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.UUID;

@Repository
public class ClubEventRestRepository implements ClubEventRepository {
    private final RestTemplate restTemplate;
    @Autowired
    public ClubEventRestRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/clubs/{id}", id);
    }

    @Override
    public void add(Club club) {
        restTemplate.put("/api/clubs/{id}", club, club.getId());
    }
}
