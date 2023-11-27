package marcin.stenka.footballapp.player.dto;
import java.util.UUID;
import java.util.List;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPlayersResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode

    public static class Player{
        private UUID id;
        private String name;
        private String surname;
        private Integer age;
    }

    @Singular
    private List<Player> players;
}
