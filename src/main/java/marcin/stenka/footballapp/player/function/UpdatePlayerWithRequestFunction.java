package marcin.stenka.footballapp.player.function;

import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.dto.PatchPlayerRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdatePlayerWithRequestFunction implements BiFunction<Player, PatchPlayerRequest, Player> {
    @Override
    public Player apply(Player entity, PatchPlayerRequest request){
        return Player.builder()
                .id(entity.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .build();
    }
}
