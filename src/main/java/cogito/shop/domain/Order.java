package cogito.shop.domain;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(name = "orders_seq")
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders_seq")
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Address address;

}
