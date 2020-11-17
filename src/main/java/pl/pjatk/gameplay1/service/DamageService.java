package pl.pjatk.gameplay1.service;

import pl.pjatk.gameplay1.model.*;

public class DamageService {
    Player attacker;
    Player defender;


    public DamageService(Player attacker, Player defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Player attack(Player attacker) {

        attacker.setHealth(attacker.getHealth() - 10);
        return attacker;
    }

    public Player defend(Player defender) {

        defender.setDamage(defender.getDamage() + 10);
        return defender;
    }
}
