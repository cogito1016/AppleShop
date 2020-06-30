package cogito.showMeThePC.domain;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(name = "setting_seq")
public class Setting {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "setting_seq")
    @Column(name = "setting_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Part processor;
    @Embedded
    private Part graphicCard;
    @Embedded
    private Part ram;
    @Embedded
    private Part storage;

}
