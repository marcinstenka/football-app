package marcin.stenka.footballapp.player;

import marcin.stenka.footballapp.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Player findBySurname(String surname);
    Optional<Player> findById(UUID id);
    void deleteById(UUID id);
    List<Player> findAll();
    List<Player> findAllByClub(Club club);
    void deleteById(Player player);

}