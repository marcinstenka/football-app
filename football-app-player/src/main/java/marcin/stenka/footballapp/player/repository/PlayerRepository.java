package marcin.stenka.footballapp.player.repository;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.player.entity.Player;
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

}