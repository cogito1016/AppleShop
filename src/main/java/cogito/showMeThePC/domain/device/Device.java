package cogito.showMeThePC.domain.device;

import cogito.showMeThePC.domain.BaseEntity;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.enumType.DeviceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@SequenceGenerator(name = "device_seq")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Device extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "device_seq")
    @Column(name = "device_id")
    private Long id;

    private String name;
    private int price;
    private String site;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setting_id")
    private Setting setting;

}
