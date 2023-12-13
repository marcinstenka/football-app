package marcin.stenka.footballapp.club.function;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.dto.PatchClubRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdateClubWithRequestFunction implements BiFunction<Club, PatchClubRequest, Club>{
    @Override
    public Club apply(Club entity, PatchClubRequest request){
        return Club.builder()
                .id(entity.getId())
                .name(request.getName())
                .foundingYear(request.getFoundingYear())
                .build();
    }
}
