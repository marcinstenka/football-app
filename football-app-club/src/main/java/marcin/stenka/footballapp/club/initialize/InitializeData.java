package marcin.stenka.footballapp.club.initialize;

import marcin.stenka.footballapp.club.entity.Club;
import marcin.stenka.footballapp.club.service.ClubService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class    InitializeData implements InitializingBean {
    private final ClubService clubService;
    @Autowired
    public InitializeData(ClubService clubService){
        this.clubService = clubService;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        if(clubService.findAll().isEmpty()){
            Club barcelona = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1")).name("Barcelona").foundingYear(1899).build();
            Club realMadrid = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2")).name("Real Madrid").foundingYear(1902).build();
            Club liverpool = Club.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3")).name("Liverpool").foundingYear(1892).build();
            clubService.addClub(barcelona);
            clubService.addClub(realMadrid);
            clubService.addClub(liverpool);
        }
    }
}
