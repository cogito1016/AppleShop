package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.Setting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class SettingRepository {

    private final EntityManager em;

    public Long saveSetting(Setting setting){
        em.persist(setting);
        return setting.getId();
    }//saveSetting() end

    public Setting findOne(Long id){
        return em.find(Setting.class, id);
    }//findOne() end
}
