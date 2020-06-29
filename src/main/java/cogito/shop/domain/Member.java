package cogito.shop.domain;

import cogito.shop.domain.enumType.MemberStatus;
import lombok.Getter;

import javax.persistence.*;

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
}
