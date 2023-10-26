package marcin.stenka.footballapp.data;

import jakarta.annotation.PostConstruct;
import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.ClubService;
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    @Autowired
    private final PlayerService playerService;
    @Autowired
    private final ClubService clubService;
    @Autowired
    public InitializeData(PlayerService playerService, ClubService clubService) {
        this.playerService = playerService;
        this.clubService = clubService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        clubService.deleteAll();
        playerService.deleteAll();
        Club barcelona = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1")).name("Barcelona").foundingYear(1899).build();
        Club realMadrid = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2")).name("Real Madrid").foundingYear(1902).build();
        Club liverpool = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3")).name("Liverpool").foundingYear(1892).build();
        Player player1 = Player.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a4")).name("Robert").surname("Lewandowski").age(33).club(barcelona).build();
        Player player2 = Player.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a5")).name("Ronald").surname("Araujo").age(24).club(barcelona).build();
        Player player3 = Player.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6")).name("Vinicius").surname("Junior").age(23).club(realMadrid).build();
        Player player4 = Player.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7")).name("Virgil").surname("Van Dijk").age(32).club(liverpool).build();

        List<Player> players = List.of(player1, player2, player3, player4);
        List<Club> clubs = List.of(barcelona, realMadrid, liverpool);
        for (Club club:clubs) {
            clubService.addClub(club);
        }
        for (Player player:players) {
            playerService.addPlayer(player);
        }
    }
}
