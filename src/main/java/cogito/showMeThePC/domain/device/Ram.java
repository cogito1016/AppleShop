package cogito.showMeThePC.domain.device;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("R")
public class Ram extends Device{
}
