package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Game;
import cogito.showMeThePC.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameService {

    private final GameRepository gameRepository;

    @Transactional
    public Long save(Game game){
        Long findId = gameRepository.save(game);
        return findId;
    }//save() end

    public Game findOne(Long id){
        return gameRepository.findOne(id);
    }//findOne() end
}
