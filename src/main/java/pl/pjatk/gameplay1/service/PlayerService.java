package pl.pjatk.gameplay1.service;

import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;

import java.util.*;

@Service
public class PlayerService {


    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();




    public List<Player> findAll(){
        List<Player> players = new ArrayList<>();
//        players.add(player1);
//        players.add(player2);
//        players.add(player3);

        return List.of(
                new Player(1, "Player one", 10, 100),
                new Player(2, "Player two", 10, 100)
        );




    }


}
