package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.dto.GetPlayersResponse;

import java.util.List;
import java.util.function.Function;

public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse>  {
    @Override
    public GetPlayersResponse apply(List<Player> entities){
        return GetPlayersResponse.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getId())
                                .name(player.getName())
                                .build())
                        .toList())
                .build();
    }
}
