package marcin.stenka.footballapp.player.entity;


import jakarta.persistence.*;
import lombok.*;
import marcin.stenka.footballapp.club.entity.Club;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "players")
public class Player implements Serializable {
    @Id
    private UUID id;
    @Column(name = "player_name")
    private String name;
    @Column(name = "player_surname")
    private String surname;
    @Column(name = "player_age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "club")
    private Club club;


}
