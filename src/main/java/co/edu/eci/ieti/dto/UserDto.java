package co.edu.eci.ieti.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor
public class UserDto {

    private String name;
    private String lastName;
    private String email;
    private Date createdAt;

}
