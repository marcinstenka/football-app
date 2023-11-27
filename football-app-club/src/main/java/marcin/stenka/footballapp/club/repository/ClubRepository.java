package marcin.stenka.footballapp.club.repository;

import marcin.stenka.footballapp.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClubRepository extends JpaRepository<Club, UUID> {
    Club findByName(String name);
    Optional<Club> findById(UUID id);
}