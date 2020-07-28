package cogito.showMeThePC.controller;

import cogito.showMeThePC.domain.Address;
import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import cogito.showMeThePC.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String registerForm(Model model){
        model.addAttribute("form",new MemberDTO());
        return "registerForm";
    }//registerForm() end

    @PostMapping("/member")
    public String register(MemberDTO memberDTO){//1.채워진 폼이 넘겨올테니
        //2.실제 Member엔티티의 객체를 새성해서 폼의 내용을 채워넣고
        Member member = Member.createMember(memberDTO.getName(),
                MemberStatus.USER, new Address(memberDTO.getCity(),memberDTO.getStreet(),memberDTO.getZipcode()),
                memberDTO.getEmail(),memberDTO.getPassword());
        //3.MemberService의 save동작을 수행해야한다.
        memberService.save(member);
        return "index";
    }//register() end

    @GetMapping("/logIn")
    public String logInForm(){
        return "logInForm"; //login 뷰 생성필요
    }//logInForm() end

    @PostMapping("/logIn")
    public String logIn(String email, String password, HttpSession session){
        //로그인가능여부 판단
        if(memberService.isMemberExist(email, password)){
            session.setAttribute("logInMember",memberService.findOneByEmail(email));
        }else{
            return "logInForm";
        }
        return "index";
    }//logIn() end

}
