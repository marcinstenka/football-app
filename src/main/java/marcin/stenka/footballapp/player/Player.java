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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {
    @Id
    private UUID id;
//    @Column(name = "player_name")
    private String name;
//    @Column(name = "player_surname")
    private String surname;
//    @Column(name = "player_age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "club")
    @JsonIgnore
    private Club club;

    public PlayerDto toDto() {
        return new PlayerDto(this.id, this.name, this.surname, this.age, this.club.getName());
    }

//    public static class PlayerBuilder {
//        private Club club;
//
//        public Player build() {
//            Player player = new Player();
//            if (club != null) {
//                club.addPlayer(player); // CAUSE ERROR - FIND WHY
//            }
//            player.id = this.id;
//            player.name = this.name;
//            player.surname = this.surname;
//            player.age = this.age;
//            player.club = this.club;
//            return player;
//        }
//    }
    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.age, other.age);
    }
    public String toString(){
        return "Player {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", club=" + club.getName() +
                '}';
    }
    public int hashCode(){
        int x = (int) Math.pow(name.length(),(int)this.age);
        return  this.age * x + this.surname.length();
    }

}
