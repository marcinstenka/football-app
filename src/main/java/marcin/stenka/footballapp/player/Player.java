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
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {
    @Id
    private UUID id;

    private String name;
    private String surname;
    private int age;
    @ManyToOne
    @JoinColumn(name = "club")
    private Club club;

    public PlayerDto toDto() {
        return new PlayerDto(this.id, this.name, this.surname, this.age, this.club.getName());
    }

//    public static class PlayerBuilder {
//        private Club club;
//        private UUID id;
//        private String name;
//        private String surname;
//        private int age;
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
        if (club != null){
            return "Player {" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", club=" + club.getName() +
                    '}';
        } else{
            return "Player {" +
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
