package pl.pjatk.gameplay1.service;

import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;

@Component
public class PlayerMapper {

    public void mapDtoToPlayer(Player player, PlayerDTO playerDTO) {
        if (playerDTO.getHealth() != null) {
            player.setHealth(playerDTO.getHealth());
        }
        if (playerDTO.getDamage() != null) {
            player.setDamage(playerDTO.getDamage());
        }
        if (playerDTO.getName() != null) {
            player.setName(playerDTO.getName());
        }
    }

}
