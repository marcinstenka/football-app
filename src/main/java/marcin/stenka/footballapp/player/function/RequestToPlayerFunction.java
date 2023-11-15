package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.dto.PutPlayerRequest;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToPlayerFunction implements BiFunction<UUID, PutPlayerRequest, Player> {

    @Override
    public Player apply(UUID id, PutPlayerRequest request){
        return Player.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .club(
                        Club.builder()
                                .id(request.getClub())
                                .build())
                .build();
    }
}