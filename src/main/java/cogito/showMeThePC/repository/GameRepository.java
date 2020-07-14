package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class GameRepository {

    private final EntityManager em;

    public Long save(Game game){
        em.persist(game);
        return game.getId();
    }//save() end

    public Game findOne(Long id){
        return em.find(Game.class,id);
    }//findOne() end

}
