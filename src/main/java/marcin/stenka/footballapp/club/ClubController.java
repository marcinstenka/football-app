package marcin.stenka.footballapp.club;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClubController {
    private ClubService clubService;

    @GetMapping("/clubs")
    public List<Club> getAllClubs(){
        return clubService.getAllClubs();
    }
    @GetMapping("/clubs/{name}")
    public Club getByName(@PathVariable String name){
        return clubService.findByName(name);
    }
    @PostMapping("/clubs")
    public void addClub(@RequestBody Club club){

        clubService.addClub(club);
    }
}
