package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Address;
import cogito.showMeThePC.domain.Member;
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
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void 회원가입_등록(){
        Member member = Member.createMember("Kim", MemberStatus.USER, new Address("수원","효행로","101"),"gladiate116@naver.com","123");
        Long findId = memberService.save(member);
        assertEquals("회원등록 정상작동",member.getId(),findId);
    }//회원가입_등록()

    @Test(expected = IllegalStateException.class)
    public void 회원가입_중복검증(){
        Member member1 = Member.createMember("Kim", MemberStatus.USER, new Address("수원","효행로","101"),"gladiate116@naver.com","123");
        Member member2 = Member.createMember("Lee", MemberStatus.USER, new Address("수원","효행로","101"),"gladiate116@naver.com","123");
        memberService.save(member1);
        memberService.save(member2);
        fail("iligalStateException이 발생해야 합니다");
    }//회원가입_중복껌증

    @Test
    public void 로그인_체크(){
        //what
        Member member = Member.createMember("Kim", MemberStatus.USER, new Address("수원","효행로","101"),"hello@naver.com","123");
        Long findId = memberService.save(member);

        //when
        boolean trueCase = memberService.isMemberExist(member.getEmail(),member.getPassword());
        boolean falseCase = memberService.isMemberExist("hihi",member.getPassword());
        boolean falseCase2 = memberService.isMemberExist(member.getEmail(),"0000");
        boolean falseCase3 = memberService.isMemberExist("hihi","0000");

        //then
        assertEquals("정확한 이메일과 정확한 비밀번호의 경우",true,trueCase);
        assertEquals("틀린 이메일과 정확한 비밀번호의 경우",false,trueCase);
        assertEquals("정확한 이메일과 틀린 비밀번호의 경우",false,trueCase);

    }


}