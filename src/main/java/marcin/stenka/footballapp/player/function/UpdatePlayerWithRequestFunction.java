package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.dto.PatchPlayerRequest;

import java.util.function.BiFunction;

public class UpdatePlayerWithRequestFunction implements BiFunction<Player, PatchPlayerRequest, Player> {
    @Override
    public Player apply(Player entity, PatchPlayerRequest request){
        return Player.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(request.getAge())
                .build();
    }
}
