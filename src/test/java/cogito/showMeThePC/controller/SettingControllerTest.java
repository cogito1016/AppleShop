package cogito.showMeThePC.controller;

import cogito.showMeThePC.ShopApplication;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.service.GameService;
import cogito.showMeThePC.service.SettingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SettingControllerTest {

//    @Autowired
//    MockMvc mockMvc;

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    private GameService gameService;
    @MockBean
    private SettingService settingService;

//    @Test
//    public void 세팅테스트() throws Exception {
//        System.out.println("hello");
//        mockMvc.perform(get("/setting/game/1/member/102"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

    @Test
    public void 세팅테스트() throws  Exception {
        Setting setting = testRestTemplate.getForObject("/setting/game/1/member/102",Setting.class);
        setting.showSettingInfo();
    }
}