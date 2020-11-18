package pl.pjatk.gameplay1.service;

import pl.pjatk.gameplay1.model.*;

public class DamageService {
    Player attacker;
    Player defender;


    public DamageService(Player attacker, Player defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public static Player defend(Player attacker, Player defender) {

        int newhealth;

        newhealth = defender.getHealth() - attacker.getDamage();

        if(newhealth < 0){
            newhealth = 0;
        }

        defender.setHealth(newhealth);
        return defender;
    }

    public static Player attack(Player attacker, Player defender) {

        int newhealth;

        newhealth = defender.getHealth() - attacker.getDamage();

        if(newhealth < 0){
            newhealth = 0;
        }

        attacker.setHealth(newhealth);
        return attacker;
    }

}
