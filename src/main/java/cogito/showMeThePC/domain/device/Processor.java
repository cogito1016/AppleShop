package cogito.showMeThePC.domain.device;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("P")
public class Processor extends Device{
}
