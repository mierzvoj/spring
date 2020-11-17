package pl.pjatk.gameplay1.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import pl.pjatk.gameplay1.model.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {



}
