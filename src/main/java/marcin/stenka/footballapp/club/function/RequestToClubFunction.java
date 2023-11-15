package marcin.stenka.footballapp.club.function;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.dto.PutClubRequest;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToClubFunction implements BiFunction<UUID, PutClubRequest, Club> {
    @Override
    public Club apply(UUID id, PutClubRequest request){
        return Club.builder()
                .id(id)
                .name(request.getName())
                .foundingYear(request.getFoundingYear())
                .build();
    }
}
