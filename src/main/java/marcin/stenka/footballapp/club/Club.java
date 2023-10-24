package marcin.stenka.footballapp.club;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import marcin.stenka.footballapp.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "clubs")
public class Club implements Comparable<Club>, Serializable {

    private String name;
    private int foundingYear;
    @Builder.Default
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
        int x = (int) Math.pow(name.length(),(int)this.foundingYear);
        return  x;
    }

}
