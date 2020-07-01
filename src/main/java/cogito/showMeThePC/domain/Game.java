package cogito.showMeThePC.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(name = "game_seq")
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "game_seq")
    @Column(name="game_id")
    private Long id;

    private String name;
    private String minProcessorName;
    private String minRamName;
    private String minGraphicName;
    private String minStorageName;

}
