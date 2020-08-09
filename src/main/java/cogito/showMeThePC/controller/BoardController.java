package cogito.showMeThePC.controller;

import cogito.showMeThePC.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"/","/index"})
    public String boards(Model model){
        model.addAttribute("boards",boardService.findAll());
        return "index";
    }//boards() end
}
