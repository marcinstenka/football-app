package marcin.stenka.footballapp.cmd;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.club.service.ClubService;
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.service.PlayerService;
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
        main_loop:
        while(true) {
            command = scanner.next();
            System.out.println(command);
            switch (command) {
                case "help" ->{
                    System.out.println("1. get_player SURNAME");
                    System.out.println("2. get_club NAME");
                    System.out.println("3. get_all_players");
                    System.out.println("4. get_all_clubs");
                    System.out.println("5. delete_player SURNAME");
                    System.out.println("6. delete_club NAME");
                    System.out.println("7. add_player ID NAME SURNAME AGE CLUB");
                    System.out.println("8. add_club ID NAME FOUNDINGYEAR");
                    System.out.println("9. change_player_club SURNAME NAME");
                    System.out.println("10. DOES NOT WORK - get_club_players");
                }
                case "get_player" -> {
                    String surname = scanner.next();
                    Player player = playerService.findBySurname(surname);
                    if (player != null){
                        System.out.println(player);
                    } else{
                        System.out.println("Nie ma takiego zawodnika w bazie danych!");
                    }
                }
                case "get_club" -> {
                    String name = scanner.next();
                    Club club = clubService.findByName(name);
                    if (club != null){
                        System.out.println(club);
                    } else{
                        System.out.println("Nie ma takiego klubu w bazie danych!");
                    }
                }
                case "get_all_players" ->{
                    List<Player> players = playerService.getAllPlayers();
                    System.out.println(players);
                }
                case "get_all_clubs" ->{
                    List<Club> clubs = clubService.findAll();
                    System.out.println(clubs);
                }

                case "delete_player" -> {
                    String surname = scanner.next();
                    Player player = playerService.findBySurname(surname);
                    if (player != null){
                        playerService.deleteBySurname(surname);
                        System.out.println("Zawodnik usunięty!");
                    } else{
                        System.out.println("Nie ma takiego zawodnika w bazie danych!");
                    }
                }
                case "delete_club" -> {
                    String name = scanner.next();
                    Club club = clubService.findByName(name);
                    if (club != null){
                        clubService.deleteByName(name);
                        System.out.println("Klub usunięty!");
                    } else{
                        System.out.println("Nie ma takiego klubu w bazie danych!");
                    }
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
                        System.out.println("Nie ma takiego klubu lub istnieje już zawodnik z takim nazwiskiem!");
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
                        System.out.println("Taki klub już istenieje!");
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
                        System.out.println("Nie ma takiego klubu lub nie istnieje zawodnik z takim nazwiskiem!");
                    }
                }
                case "get_club_players" -> {
                    String clubName = scanner.next();
                    Club club= clubService.findByName(clubName);
                    if (club != null ){
                        System.out.println(club.getPlayers());
                    }else {
                        System.out.println("Nie ma takiego klubu w bazie danych!");
                    }
                }
                case "quit" -> {

                    break main_loop;

                }
            }
        }
        System.exit(0);
    }
}