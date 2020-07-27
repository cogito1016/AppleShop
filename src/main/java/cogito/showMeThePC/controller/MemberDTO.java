package cogito.showMeThePC.controller;

import cogito.showMeThePC.domain.Address;
import cogito.showMeThePC.domain.Setting;
import cogito.showMeThePC.domain.enumType.MemberStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MemberDTO {
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
    private String email;
    private String password;
}
