package cogito.showMeThePC.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@SequenceGenerator(name = "game_seq")
public class Game extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "game_seq")
    @Column(name="game_id")
    private Long id;

    private String name;
    private String minProcessorName;
    private String minRamName;
    private String minGraphicName;
    private String minStorageName;

    public Game(){}
    public Game(String name, String minProcessorName, String minRamName, String minGraphicName, String minStorageName) {
        this.name = name;
        this.minGraphicName=minGraphicName;
        this.minProcessorName=minProcessorName;
        this.minRamName=minRamName;
        this.minStorageName=minStorageName;
        super.setCreatedTime(LocalDateTime.now());
    }
    public static Game createGame(String name, String minProcessorName, String minRamName, String minGraphicName, String minStorageName){
        Game game = new Game(name,minProcessorName,minRamName,minGraphicName,minStorageName);
        return game;
    }//createGame() end



}
