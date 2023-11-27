package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.entity.Player;
import marcin.stenka.footballapp.player.dto.GetPlayersResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse>  {
    @Override
    public GetPlayersResponse apply(List<Player> entities){
        return GetPlayersResponse.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getId())
                                .name(player.getName())
                                .surname(player.getSurname())
                                .build())
                        .toList())
                .build();
    }
}
