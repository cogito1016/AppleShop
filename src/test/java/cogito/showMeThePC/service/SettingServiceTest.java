package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.device.Device;
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
public class SettingServiceTest {

    @Autowired private SettingService settingService;
    @Autowired private DeviceService deviceService;

    @Test
    public void 세팅정보_정상삽입확인(){

        Setting setting = new Setting();
        Long findId = settingService.saveSetting(setting);

        assertEquals("정상 삽입되었는지 확인합니다",setting,settingService.findOne(findId));
    }

    @Test
    @Rollback(false)
    public void 세팅_디바이스_디바이스테이블_정상삽입확인(){

        Device device1 = new Device();
        device1.setSite("naver");

        Setting setting = new Setting();
        setting.getDevices().add(device1);
        Long findId = settingService.saveSetting(setting);

        assertEquals("세팅내에 있는 디바이스가 디바이스테이블에 삽입되었는지 확인합니다",device1,deviceService.findOne(device1.getId()));

    }

}