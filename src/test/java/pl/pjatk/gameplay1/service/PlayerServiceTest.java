package pl.pjatk.gameplay1.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.data.domain.*;
import pl.pjatk.gameplay1.model.*;
import pl.pjatk.gameplay1.repository.*;

import java.security.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock
    private DamageService damageService;
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerService playerService;

    //private PlayerService playerService = new PlayerService(playerRepository, damageService);


    Player attacker = new Player("testplayer", 100, 200);
    Player defender = new Player("testplayer", 100, 200);


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        //Given
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));
        //When
        List<Player> all = playerService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void findById() {
        //Given
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player()));
        //When
        Optional<Player> player = playerService.findById(1L);
        //Then
        assertThat(player).isNotEmpty();
    }

    @Test
    void savePlayer() {
        //Given
        Player p1 = new Player("p1", 100, 200);
        Player p2 = new Player(1L, "p2", 100, 200);
        //When
        when(playerRepository.save(p1)).thenReturn(p2);

        assertThat(playerService.savePlayer(p1).getId()).isEqualTo(p2.getId());

    }

    @Test
    void shouldDelete() {
        playerService.deletePlayer(1L);
        playerService.deletePlayer(1L);
        verify(playerRepository, times(2)).deleteById(anyLong());
    }

    @Test
    void attack() {

        Player attacker = new Player(1L, "Attacker", 50, 1000);
        Player defender = new Player(2L, "Defender", 50, 1000);
        when(damageService.attack(any(), any())).thenCallRealMethod();

        when(playerRepository.findById(1L)).thenReturn(Optional.of(attacker));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(defender));


        when(playerRepository.save(defender)).thenReturn(defender);

        playerService.attack(attacker.getId(), defender.getId());

        assertThat(defender.getHealth()).isEqualTo(950);
    }
}
