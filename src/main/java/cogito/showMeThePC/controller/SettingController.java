package cogito.showMeThePC.controller;

import cogito.showMeThePC.domain.device.Device;
import cogito.showMeThePC.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SettingController {

    private final GameService gameService;

    @GetMapping("/setting")
    public String settingForm(Model model){
        model.addAttribute("games",gameService.findAll()); //게임 리스트를 넘겨줘야 함
        return "settingForm";
    }//settingForm() end

    @GetMapping("/setting/{gameId}")
    @ResponseBody
    public List<Device> settingResult(@PathVariable int gameId){
        List<Device> list = null; //Game Id를 통한 세팅 결과 담아 출력
        return list;
    }

}
