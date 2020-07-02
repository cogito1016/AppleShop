package cogito.showMeThePC.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(name = "board_seq")
public class Board extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "board_seq")
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="setting_id")
    private Setting setting;

    @Lob
    private String content;
}
