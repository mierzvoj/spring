package pl.pjatk.gameplay1.service;

import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;
import pl.pjatk.gameplay1.repository.*;

import javax.swing.text.html.*;
import java.util.*;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> findAll() {

        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {

        return playerRepository.findById(id);
//
    }


    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {

        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Long id, PlayerDTO playerWithUpdatesProperties) {
        Player dbPlayer = playerRepository.findById(id).get();

        if (playerWithUpdatesProperties.getHealth() != null) {
            dbPlayer.setHealth(playerWithUpdatesProperties.getHealth());
        }
        if (playerWithUpdatesProperties.getDamage() != null) {
            dbPlayer.setDamage(playerWithUpdatesProperties.getDamage());
        }

        if (playerWithUpdatesProperties.getName() != null) {
            dbPlayer.setName(playerWithUpdatesProperties.getName());
        }
        return playerRepository.save(dbPlayer);
    }

        public Player attack (Long attackerId, Long defenderId){
            Optional<Player> attacker = playerRepository.findById(attackerId);
            Optional<Player> defender = playerRepository.findById(defenderId);

            return null;

        }

    }
