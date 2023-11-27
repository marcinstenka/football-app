package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.entity.Player;
import marcin.stenka.footballapp.player.dto.GetPlayerResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
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
