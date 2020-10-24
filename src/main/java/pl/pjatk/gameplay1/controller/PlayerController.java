package pl.pjatk.gameplay1.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay1.model.*;
import pl.pjatk.gameplay1.service.*;

import java.util.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    //localhost/8080, żądanie player/

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping


    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }
}



