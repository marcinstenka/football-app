package marcin.stenka.footballapp.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PlayerDto implements Comparable<PlayerDto> {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private String clubName;
    @Override
    public int compareTo(PlayerDto other) {
        return Integer.compare(this.age, other.age);
    }
    public String toString(){
        return "Player {" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", club=" + clubName +
                '}';
    }
    public int hashCode(){
        int x = (int) Math.pow(name.length(),(int)this.age);
        return  this.age * x + this.surname.length();
    }
}