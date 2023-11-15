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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "clubs")
public class Club implements Comparable<Club>, Serializable {
    @Id
    private UUID id;
    @Column(name = "club_name")
    private String name;
    @Column(name = "club_foundingYear")
    private int foundingYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club")
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){
        players.add(player);
    }
    @Override
    public int compareTo(Club other) {
        int foundingYearComparsion = Integer.compare(this.foundingYear, other.foundingYear);
        if (foundingYearComparsion != 0) {
            return foundingYearComparsion;
        } else {
            return this.name.compareTo(other.name);
    }}

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
