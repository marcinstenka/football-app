package marcin.stenka.footballapp.cmd;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.ClubService;
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {
    private final PlayerService playerService;
    private final ClubService clubService;

    public ApplicationCommand(PlayerService playerService, ClubService clubService) {
        this.playerService = playerService;
        this.clubService = clubService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        while(true) {
            command = scanner.next();
            System.out.println(command);
            switch (command) {
                case "get_player" -> {
                    String surname = scanner.next();
                    Player player = playerService.findBySurname(surname);
                    System.out.println(player);
                }
                case "get_club" -> {
                    String name = scanner.next();
                    Club club = clubService.findByName(name);
                    System.out.println(club);
                }
                case "get_all_players" ->{
                    List<Player> players = playerService.getAllPlayers();
                    System.out.println(players);
                }
                case "get_all_clubs" ->{
                    List<Club> clubs = clubService.getAllClubs();
                    System.out.println(clubs);
                }
                case "get_club_players" -> {
                    String clubName = scanner.next();
                    Club club= clubService.findByName(clubName);
                    System.out.println(club.getPlayers());
                }
                case "delete_club" -> {
                    String clubName = scanner.next();
                    clubService.deleteByName(clubName);
                }
                case "delete_player" -> {
                    String player = scanner.next();
                    playerService.deleteBySurname(player);
                }
                case "add_player" -> {
                    String id = scanner.next();
                    String name = scanner.next();
                    String surname = scanner.next();
                    String age = scanner.next();
                    String clubName = scanner.next();
                    Club club = clubService.findByName(clubName);
                    Player player = playerService.findBySurname(surname);
                    if (club !=null && player == null){
                        Player newPlayer = Player.builder().id(UUID.fromString(id)).name(name).surname(surname).age(Integer.parseInt(age)).club(club).build();
                        playerService.addPlayer(newPlayer);
                        System.out.println("Zawodnik dodany.");
                    } else {
                        System.out.println("Nie ma takiego klubu lub istnieje już zawodnik z takim nazwiskiem.");
                    }
                }
                case "add_club" -> {
                    String id = scanner.next();
                    String name = scanner.next();
                    String foundingYear = scanner.next();
                    Club club = clubService.findByName(name);
                    if (club == null){
                        Club newClub = Club.builder().id(UUID.fromString(id)).name(name).foundingYear(Integer.parseInt(foundingYear)).build();
                        clubService.addClub(newClub);
                        System.out.println("Klub dodany.");
                    }else {
                        System.out.println("Taki klub już istenieje.");
                    }
                }
                case "change_player_club" -> {
                    String surname = scanner.next();
                    String clubName = scanner.next();
                    Club club = clubService.findByName(clubName);
                    Player player = playerService.findBySurname(surname);
                    if (club != null && player!=null ){
                        playerService.changePlayerClub(surname, club);
                    } else{
                        System.out.println("Nie ma takiego klubu lub nie istnieje zawodnik z takim nazwiskiem.");
                    }
                }
            }
        }
    }
}