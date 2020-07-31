package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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
    public List<Game> findAll() { return em.createQuery("select g from Game g").getResultList();}//findAll() end
}
