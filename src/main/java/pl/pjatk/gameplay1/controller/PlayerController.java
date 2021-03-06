package pl.pjatk.gameplay1.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay1.model.*;
import pl.pjatk.gameplay1.service.*;

import javax.persistence.*;
import java.util.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    //localhost/8080, żądanie player/

    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService, DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping

    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }


    @GetMapping("/{id}")


//    public ResponseEntity<Optional<Player>> findById(@PathVariable Long id) {
//        Optional<Player> byId = playerService.findById(id);
//        if (byId.isPresent()) {
//            return ResponseEntity.ok(byId);
//        } else {
//            return ResponseEntity.notFound().build();
//        }

    public ResponseEntity<Player> findById(@PathVariable Long id) {
        Optional<Player> byId = playerService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

    @DeleteMapping("/{id}/")

    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(player));
    }

    @GetMapping("/attacker/{attackerId}/defender/{defenderId}")
    public ResponseEntity<Player> attackPlayer(@PathVariable Long attackerId, @PathVariable Long defenderId) {
        return ResponseEntity.ok(playerService.attack(attackerId, defenderId));

    }

//    @GetMapping("/attacker/{attackerId}/defender/{defenderId}")
//    public ResponseEntity<Player> defendPlayer(@PathVariable Long attackerId, @PathVariable Long defenderId) {
//        return ResponseEntity.ok(playerService.defend(attackerId, defenderId));
//
//    }
}



