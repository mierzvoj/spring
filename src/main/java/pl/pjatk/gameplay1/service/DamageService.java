package pl.pjatk.gameplay1.service;

import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;
@Service
public class DamageService {
//    public Player attacker;
//    public Player defender;
//
//
//    public DamageService(Player attacker, Player defender) {
//        this.attacker = attacker;
//        this.defender = defender;
//    }
//
//    public DamageService() {
//    }

    public static Player defend(Player attacker, Player defender) {
        int newhealth;
        newhealth = defender.getHealth() - attacker.getDamage();
        if (newhealth < 0) {
            newhealth = 0;
        }
        defender.setHealth(newhealth);
        return defender;
    }
    public Player attack(Player attacker, Player defender) {
            defender.setHealth(defender.getHealth() - attacker.getDamage());
            return defender;
        }
//    public static Player attack(Player attacker, Player defender) {
//
//        int newhealth;
//
//        newhealth = defender.getHealth() - attacker.getDamage();
//
//        if (newhealth < 0) {
//            newhealth = 0;
//        }

//        attacker.setHealth(newhealth);
//        return attacker;
//    }

    public Player healPlayer(Player attacker, Player defender) {

        if ((attacker.getHealth() < 100) && defender.getHealth() > 150) {
            defender.setHealth(defender.getHealth() + 100);

        }
        return defender;
    }
    public Player damage (Player attacker, Player defender){
        if ((attacker.getHealth() > 100) && defender.getHealth() < 150) {
            attacker.setHealth(defender.getHealth() + 100);
        }
        return attacker;
    }

    public Player suddenDeath(Player attacker, Player defender){
        if((attacker.getHealth() < 5) && defender.getHealth() > 200){
            attacker.setHealth(0);
        }
        return  attacker;
    }



}
