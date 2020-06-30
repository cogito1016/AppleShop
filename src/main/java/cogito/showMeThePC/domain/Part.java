package cogito.showMeThePC.domain;

import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class Part {
    private String name;
    private int price;
    private String site;

    protected Part() {
    }

    public Part(String name, int price, String site){
        this.name=name;
        this.price=price;
        this.site=site;
    }//cons end
}
