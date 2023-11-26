package marcin.stenka.footballapp.club.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchClubRequest {
    private String name;
    private int foundingYear;
}
