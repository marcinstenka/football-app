package marcin.stenka.footballapp.player.dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PatchPlayerRequest {
    private String name;
    private String surname;
    private int age;
}
