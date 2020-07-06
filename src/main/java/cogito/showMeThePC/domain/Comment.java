package cogito.showMeThePC.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@SequenceGenerator(name = "comment_seq")
public class Comment extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_seq")
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    public Comment(){}
    public Comment(Member member, Board board, String content,Comment parent){
        this.member=member;
        this.board=board;
        this.content=content;
        this.parent=parent;
        super.setCreatedTime(LocalDateTime.now());
    }
    public static Comment createComment(Member member, Board board, String content){
        Comment comment = new Comment(member,board,content,null);
        return comment;
    }//createComment() end
    public static Comment createReply(Member member, Board board, String content,Comment parent){
        Comment reply = new Comment(member,board,content,parent);
        return reply;
    }//createReply() end


}
