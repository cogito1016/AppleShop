package cogito.shop.domain;
import cogito.shop.domain.enumType.MemberStatus;
import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SequenceGenerator(name = "member_seq")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq")
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address address;
}
