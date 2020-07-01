package cogito.showMeThePC.domain.device;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("G")
public class GraphicCard extends Device{
}
