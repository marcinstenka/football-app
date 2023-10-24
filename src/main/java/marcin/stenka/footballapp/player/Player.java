package marcin.stenka.footballapp.player;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import marcin.stenka.footballapp.club.Club;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {

    private String name;
    private String surname;
    private int age;
    private Club club;

//    public PlayerDTO toDTO() {
//        return new PlayerDTO(this.name, this.surname, this.age, this.club.getName());
//    }

//    Custom builder to set player into the club when .club()
    public static class PlayerBuilder {
        private Club club;
        public PlayerBuilder club(Club club){
            this.club = club;
            return this;
        }
        public Player build() {
            Player player = new Player();
            if (club != null) {
                club.addPlayer(player);
            }
            player.name = this.name;
            player.surname = this.surname;
            player.age = this.age;
            player.club = this.club;
            return player;
        }
    }
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
