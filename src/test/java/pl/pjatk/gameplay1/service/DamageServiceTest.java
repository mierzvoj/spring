package pl.pjatk.gameplay1.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.springframework.boot.test.context.*;
import pl.pjatk.gameplay1.model.*;

import static org.assertj.core.api.Assertions.assertThat;
//@SpringBootTest
public class DamageServiceTest {

    private DamageService damageService = new DamageService();
    @Test
    void shouldAttackPlayer(){
        //given
        Player attacker = new Player("testplayer", 100, 200);
        Player defender = new Player("testplayer", 100, 200);

        //when

        defender = damageService.attack(attacker, defender);

        //then

        assertThat(defender.getHealth()).isEqualTo(100);
    }
    @Test
    void shouldAttackerNotReceiveDamage(){
        //given
        Player attacker = new Player("testplayer", 100, 200);
        Player defender = new Player("testplayer", 100, 200);

        //when

        defender = damageService.attack(attacker, defender);

        //then

        assertThat(defender.getHealth()).isEqualTo(100);
    }

    @Test
    void shouldThereBeSuddenDeath(){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        attacker = damageService.suddenDeath(attacker, defender);
        assertThat(attacker.getHealth()).isEqualTo(0);
    }

    @Test
    @DisplayName("shouldThereBeSuddenDeath1")
    void shouldThereBeSuddenDeath1(){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        attacker = damageService.suddenDeath(attacker, defender);
        assertThat(attacker.getHealth()).isBetween(0, 500);
    }

    @Test
    void shouldWeHealHim(){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        defender = damageService.healPlayer(attacker, defender);
        assertThat(defender.getHealth()).isBetween(0, 460);

    }
    @Test
    void shouldWeHealHimOrNot(){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        defender = damageService.healPlayer(attacker, defender);
        assertThat(defender.getHealth()).isNegative();
    }
    @Test
    @DisplayName("Another test for players")
    void damageHealingTheAttacker (){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        attacker = damageService.damage(attacker, defender);
        assertThat(defender.getHealth()).isBetween(100, 150);
        assertThat(defender.getHealth()).isBetween(100, 300);
    }


    @Test
    @DisplayName("Another test for players")
    void damageTheAttacker (){
        Player attacker = new Player("testplayer", 100, 4);
        Player defender = new Player("testplayer", 100, 250);

        attacker = damageService.defend(attacker, defender);
        assertThat(attacker.getHealth()).isBetween(100, 150);

    }

}
