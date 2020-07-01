package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.device.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DeviceRepository {

    private final EntityManager em;

    public Long saveDevice(Device device){
        em.persist(device);
        return device.getId();
    }//saveDevice() end

    public Device findOne(Long id){
        return em.find(Device.class,id);
    }//findOne() end



}
