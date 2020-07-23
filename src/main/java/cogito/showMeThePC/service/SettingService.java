package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Game;
import cogito.showMeThePC.domain.Member;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.device.Device;
import cogito.showMeThePC.domain.enumType.DeviceType;
import cogito.showMeThePC.repository.GameRepository;
import cogito.showMeThePC.repository.MemberRepository;
import cogito.showMeThePC.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SettingService {

    private final SettingRepository settingRepository;
    private final GameRepository gameRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveSetting(Long gameId, Long memberId) throws IOException {

        Game game = gameRepository.findOne(gameId);
        Member member = memberRepository.findOne(memberId);

        //대상 Game의 하드웨어 정보 추출
        String graphic = game.getMinGraphicName();
        String ram = game.getMinRamName();
        String processor = game.getMinProcessorName();
        String storage = game.getMinStorageName();

        //크롤링진행후 제일 최소값으로 찾고 해당 디바이스정보(가격,사이트,명칭 등)으로 세팅을 만든다.
        Device[] devices = new Device[4];
        devices[0]=crawling(DeviceType.PROCESSOR,processor);
        devices[1]=crawling(DeviceType.RAM,ram);
        devices[2]=crawling(DeviceType.GRAPHICCARD,graphic);
        devices[3]=crawling(DeviceType.STORAGE,storage);

        //해당 Game과 Device들을 이용해서 Setting객체를 만든다.
        Setting setting = Setting.createSetting(member,game,devices);


        //그리고 Repository를 호출하여 저장한다.
        return settingRepository.saveSetting(setting);
    }//saveSetting() end

    public Device crawling(DeviceType deviceType,String s) throws IOException {

        String URL = "https://search.shopping.naver.com/search/all?frm=NVSHATC&origQuery="+s+"&pagingIndex=1&pagingSize=40&productSet=total&query="+s+"&sort=price_asc&timestamp=&viewType=list";
        Document doc = Jsoup.connect(URL).get();
        Elements nameEle = doc.select(".basicList_title__3P9Q7");
        Elements siteEle = doc.select(".basicList_title__3P9Q7 a");
        Elements priceEle = doc.select(".price_num__2WUXn");

        String name = nameEle.get(0).text();
        int price = Integer.parseInt(priceEle.get(0).text().replace("원","").replace(",",""));
        String site = siteEle.get(0).attr("href");

        return Device.createDevice(name,price,site,deviceType);
    }

    public Setting findOne(Long id){
        return settingRepository.findOne(id);
    }//findOne() end
}
