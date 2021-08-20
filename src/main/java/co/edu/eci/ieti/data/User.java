package co.edu.eci.ieti.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class User {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private Date createAt;

    @Override
    public boolean equals(Object object) {
        return equals((User) object);
    }

    public boolean equals(User user) {
        return id.equals(user.getId());
    }

}
