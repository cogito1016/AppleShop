package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public Long save(Board board){
        em.persist(board);
        return board.getId();
    }//save() end

    public Board findOne(Long id){
        return em.find(Board.class,id);
    }//findOne() end

    public List<Board> findAll() { return em.createQuery("select b from Board b").getResultList();}//findAll() end
}
