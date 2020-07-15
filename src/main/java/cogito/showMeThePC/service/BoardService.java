package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Board;
import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.repository.BoardRepository;
import cogito.showMeThePC.repository.MemberRepository;
import cogito.showMeThePC.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final SettingRepository settingRepository;

    @Transactional
    public Long save(Long memberId, Long settingId,String content,String title){

        Member member = memberRepository.findOne(memberId);
        Setting setting;
        if(settingId==null)
            setting=null;
        else
            setting=settingRepository.findOne(settingId);
        Board board = Board.createBoard(member,setting,content,title);
        boardRepository.save(board);
        return board.getId();
    }//save() end

    public Board findOne(Long boardId){
        return boardRepository.findOne(boardId);
    }//findOne() end

}
