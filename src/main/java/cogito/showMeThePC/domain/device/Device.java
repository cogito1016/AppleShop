package cogito.showMeThePC.domain.device;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@SequenceGenerator(name = "device_seq")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Device {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "device_seq")
    @Column(name = "device_id")
    private Long id;

    private String name;
    private int price;
    private String site;

}
