package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GameServiceTest {

    @Autowired private GameService gameService;

    @Test
    public void 게임등록(){
        Game game = Game.createGame("디아블로3","Intel i5","8GB","IrisPlus650","50GB");

        Long findId = gameService.save(game);

        assertEquals("정상등록 되었는지 확인",game,gameService.findOne(findId));
    }//게임등록() end

}