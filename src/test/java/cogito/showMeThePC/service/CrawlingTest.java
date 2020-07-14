package cogito.showMeThePC.service;


import cogito.showMeThePC.domain.enumType.DeviceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlingTest {

    @Autowired SettingService settingService;

    @Test
    public void 크로울링테스트() throws IOException {

        settingService.crawling(DeviceType.PROCESSOR,"i5 10400");

    }//크로울링테스트() end

}
