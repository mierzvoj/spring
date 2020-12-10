package pl.pjatk.gameplay1.service;

import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;
import pl.pjatk.gameplay1.repository.*;

import javax.swing.text.html.*;
import java.util.*;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    private DamageService damageService;

    public PlayerService(PlayerRepository playerRepository, DamageService damageService) {
        this.playerRepository = playerRepository;
        this.damageService = damageService;
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

    public Player updatePlayer(Player player) {


        return playerRepository.save(player);
    }

    public Player attack(Long attackerId, Long defenderId) {
        Player attacker = playerRepository.findById(attackerId).get();
        Player defender = playerRepository.findById(defenderId).get();

        attacker = DamageService.attack(attacker, defender);

        return playerRepository.save(attacker);

    }
//    public Player defend(Long attackerId, Long defenderId) {
//        Player attacker = playerRepository.findById(attackerId).get();
//        Player defender = playerRepository.findById(defenderId).get();
//
//        defender = DamageService.defend(attacker, defender);
//
//        return playerRepository.save(defender);
//
//    }
}
