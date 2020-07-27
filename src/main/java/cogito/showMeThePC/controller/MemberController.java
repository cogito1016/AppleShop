package cogito.showMeThePC.controller;

import cogito.showMeThePC.domain.Address;
import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import cogito.showMeThePC.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String registerForm(Model model){
        model.addAttribute("form",new MemberDTO()); //폼을 붙여 넘겼으니 뷰에선 그 폼을 채워야함
        return "registerForm";
    }//registerForm() end

    @PostMapping("/member")
    public String register(MemberDTO memberDTO){//1.채워진 폼이 넘겨올테니
        //2.실제 Member엔티티의 객체를 새성해서 폼의 내용을 채워넣고
        Member member = Member.createMember(memberDTO.getName(),
                MemberStatus.USER, new Address(memberDTO.getCity(),memberDTO.getStreet(),memberDTO.getZipcode()),
                memberDTO.getEmail());
        //3.MemberService의 save동작을 수행해야한다.
        memberService.save(member);
        return "index";
    }
}
