package marcin.stenka.footballapp.player;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import marcin.stenka.footballapp.club.Club;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {
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

    @Override
    public int compareTo(Player other) {
        int ageComparison = Integer.compare(this.age, other.age);

        if (ageComparison != 0) {
            return ageComparison;
        } else {
            return this.surname.compareTo(other.surname);
        }    }
    public String toString(){
        if (club != null){
            return "Player {" +
                    "id='" + id + '\'' +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", club=" + club.getName() +
                    '}';
        } else{
            return "Player {" +
                    "id='" + id + '\'' +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", club=NONE"  +
                    '}';
        }


    }
    public int hashCode(){
        int x = (int) Math.pow(name.length(),(int)this.age);
        return  this.age * x + this.surname.length();
    }

}
