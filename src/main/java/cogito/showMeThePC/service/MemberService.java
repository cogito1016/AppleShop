package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Member member){
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }//save() end

    private void validateDuplicatedMember(Member member){
        if(!memberRepository.findOneByEmail(member.getEmail()).isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }//if end
    }//validateDuplicatedMember() //

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }//findOne() end

    public Member findOneByEmail(String email) {
        List<Member> list =  memberRepository.findOneByEmail(email);
        if(list.isEmpty()){
           throw new IllegalStateException("해당 이메일을 가진 회원이 존재하지 않습니다");
        }
        return list.get(0);
    }//findByEmail() end

    public boolean isMemberExist(String email, String password){
        if(!memberRepository.findOneByEmailAndPassword(email, password).isEmpty()){
            return true;
        }else{
            return false;
        }
    }//isMemberExist() end
}
