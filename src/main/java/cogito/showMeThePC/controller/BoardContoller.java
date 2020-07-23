package cogito.showMeThePC.controller;

import cogito.showMeThePC.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardContoller {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String boards(Model model){

        model.addAttribute("boards",boardService.findAll());
        return "index";
    }
}
