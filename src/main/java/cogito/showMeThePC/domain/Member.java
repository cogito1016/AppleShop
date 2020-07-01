package cogito.showMeThePC.domain;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@SequenceGenerator(name = "member_seq")
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq")
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToMany(mappedBy = "member")
    private List<Setting> settings = new ArrayList<>();

    @Embedded
    private Address address;

    private String email;

    private boolean quoteState;
}
