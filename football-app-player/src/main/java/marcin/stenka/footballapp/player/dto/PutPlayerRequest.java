package marcin.stenka.footballapp.player.dto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPlayerRequest {
    private String name;
    private String surname;
    private int age;
    private UUID club;
}
