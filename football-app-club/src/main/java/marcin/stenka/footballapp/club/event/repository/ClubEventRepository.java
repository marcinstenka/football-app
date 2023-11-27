package marcin.stenka.footballapp.club.event.repository;

import marcin.stenka.footballapp.club.entity.Club;

import java.util.UUID;

public interface ClubEventRepository {
    void delete(UUID id);
    void add(Club club);
}
