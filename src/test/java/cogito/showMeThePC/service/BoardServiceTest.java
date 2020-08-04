package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.*;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired private BoardService boardService;
    @Autowired private MemberService memberService;

    @Test
    public void 커뮤니티글_작성(){
        Member member = Member.createMember("Kim", MemberStatus.USER, new Address("수원","효행로","101"),"gladiate116@naver.com","123");
        memberService.save(member);
        Long settingId = null;

        String content = "반갑다~";
        String title = "여보세요";
        Long findId = boardService.save(member.getId(),settingId,content,title);

        assertEquals("커뮤니티글 작성자가 정상적으로 들어가있는지 확인합니다",boardService.findOne(findId).getMember(),member);
        assertEquals("글 내용이 정확한지 확인합니다",boardService.findOne(findId).getContent(),content);
    }

    @Test
    public void 커뮤니티글_세팅존재_총가격() {
        Board board = boardService.findOne(52L);  //ID는 계속변경되어야함
        int price = board.getTotalPrice();
        System.out.println(price);
        assertEquals(777041, price);
    }
}