package marcin.stenka.footballapp.club.function;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.dto.GetClubResponse;

import java.util.UUID;
import java.util.function.Function;

public class ClubToResponseFunction implements Function<Club, GetClubResponse> {
    @Override
    public GetClubResponse apply(Club entity){
        return GetClubResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .foundingYear(entity.getFoundingYear())
                .build();
        }
}
