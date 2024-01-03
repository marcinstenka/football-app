package marcin.stenka.footballapp.club.entity;


import jakarta.persistence.*;
import lombok.*;
import marcin.stenka.footballapp.player.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "clubs")
public class Club implements Serializable {
    @Id
    private UUID id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Player> players = new ArrayList<Player>();

}
