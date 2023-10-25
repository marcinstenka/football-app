package marcin.stenka.footballapp.club;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import marcin.stenka.footballapp.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "clubs")
public class Club implements Comparable<Club>, Serializable {
    @Id
    private UUID id;

    @Column(name = "club_name")
    private String name;
    @Column(name = "club_founding_year")
    private int foundingYear;
    @Column(name = "club_players")
    @Builder.Default
    @OneToMany(mappedBy = "club")
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){

        players.add(player);
    }

    @Override
    public int compareTo(Club other) {
        return Integer.compare(this.foundingYear, other.foundingYear);
    }

    public String toString() {
        return "Club {" +
                "name='" + name + '\'' +
                ", foundingYear=" + foundingYear +
                '}';
    }
    public int hashCode(){
        return  (int) Math.pow(name.length(),(int)this.foundingYear);
    }

}
