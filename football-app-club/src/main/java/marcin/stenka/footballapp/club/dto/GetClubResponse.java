package marcin.stenka.footballapp.club.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetClubResponse {
    private UUID id;
    private String name;
    private int foundingYear;
}
