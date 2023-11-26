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
@AllArgsConstructor
@Entity
@Table(name = "clubs")
public class Club implements Comparable<Club>, Serializable {
    @Id
    private UUID id;
    @Column(name = "club_name")
    private String name;
    @Column(name = "club_foundingYear")
    private int foundingYear;

<<<<<<< HEAD
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    @Builder.Default
=======
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.REMOVE)
>>>>>>> aa150c01edb0796bff6158c6c0892089e8bfeff9
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", foundingYear=" + foundingYear +
                '}';
    }
    public int hashCode(){
        return  (int) Math.pow(name.length(),(int)this.foundingYear);
    }

}
