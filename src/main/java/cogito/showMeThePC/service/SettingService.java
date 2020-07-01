package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SettingService {

    private final SettingRepository settingRepository;

    @Transactional
    public Long saveSetting(Setting setting){
        return settingRepository.saveSetting(setting);
    }//saveSetting() end

    public Setting findOne(Long id){
        return settingRepository.findOne(id);
    }//findOne() end
}
