package cogito.showMeThePC.service;

import cogito.showMeThePC.domain.device.Device;
import cogito.showMeThePC.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Transactional
    public Long saveDevice(Device device){

        Long deviceId = deviceRepository.saveDevice(device);

        return deviceId;
    }

    public Device findOne(Long id){
        return deviceRepository.findOne(id);
    }
}
