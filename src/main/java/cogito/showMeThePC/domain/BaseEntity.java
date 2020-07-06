package cogito.showMeThePC.domain;

import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
public class BaseEntity {
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;
}
