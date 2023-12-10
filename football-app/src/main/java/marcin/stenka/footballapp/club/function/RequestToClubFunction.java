package marcin.stenka.footballapp.club.function;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.dto.PutClubRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToClubFunction implements BiFunction<UUID, PutClubRequest, Club> {
    @Override
    public Club apply(UUID id, PutClubRequest request){
    System.out.println(request.getFoundingYear());
        return Club.builder()
                .id(id)
                .name(request.getName())
                .foundingYear(request.getFoundingYear())
                .build();
    }
}
