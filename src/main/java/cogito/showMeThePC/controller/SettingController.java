package cogito.showMeThePC.controller;

import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.device.Device;
import cogito.showMeThePC.service.GameService;
import cogito.showMeThePC.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SettingController {

    private final GameService gameService;
    private final SettingService settingService;

    @GetMapping("/setting")
    public String settingForm(Model model){
        model.addAttribute("games",gameService.findAll()); //게임 리스트를 넘겨줘야 함
        return "settingForm";
    }//settingForm() end

    @GetMapping("/setting/{gameId}/{memberId}")
    @ResponseBody
    public Setting settingResult(@PathVariable Long gameId,@PathVariable Long memberId, HttpSession session) throws IOException {
//        Member logInMember = (Member) session.getAttribute("logInMember");
//        System.out.println("접근 성공 gameId="+gameId+" memberId="+logInMember.getId());
//        Setting setting = settingService.runFindSetting(gameId, logInMember.getId()); //Game Id를 통한 세팅 결과 담아 출력
        System.out.println("컨트롤러 접근은 성공");
        Setting setting = settingService.runFindSetting(gameId,memberId);
        return setting;
    }

}
