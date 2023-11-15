package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.dto.GetPlayerResponse;

import java.util.function.Function;

public class PlayerToResponseFunction implements Function<Player, GetPlayerResponse> {
    @Override
    public GetPlayerResponse apply(Player entity){
        return GetPlayerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .clubName(GetPlayerResponse.Club.builder()
                        .id(entity.getClub().getId())
                        .name(entity.getClub().getName())
                        .build())
                .build();
    }

}
