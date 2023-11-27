package marcin.stenka.footballapp.club.function;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.dto.GetClubsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class ClubsToResponseFunction implements Function<List<Club>, GetClubsResponse> {
    @Override
    public GetClubsResponse apply(List<Club> entities){
        return GetClubsResponse.builder()
                .clubs(entities.stream()
                        .map(club -> GetClubsResponse.Club.builder()
                                .id(club.getId())
                                .name(club.getName())
                                .foundingYear(club.getFoundingYear())
                                .build())
                        .toList())
                .build();
    }
}
