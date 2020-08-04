package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Address;
import cogito.showMeThePC.domain.Game;
import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.device.Device;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SettingServiceTest {

    @Autowired private SettingService settingService;
    @Autowired private DeviceService deviceService;
    @Autowired private GameService gameService;
    @Autowired private  MemberService memberService;

    @Test
    public void 세팅정보_정상삽입확인() throws IOException {
        Member member = Member.createMember("Kim", MemberStatus.USER, new Address("수원","효행로","101"),"gladiate116@naver.com","123");
        memberService.save(member);

        Game game = Game.createGame("디아블로3","Intel i5","8GB","IrisPlus650","50GB");
        gameService.save(game);

        Long findId = settingService.saveSetting(settingService.runFindSetting(game.getId(),member.getId()));

        Setting findSetting = settingService.findOne(findId);

        assertEquals("게임이 삽입되었는지 확인합니다",findSetting.getGame(),game);
        assertEquals("멤버가 삽입되었는지 확인합니다",findSetting.getMember(),member);
    }

}