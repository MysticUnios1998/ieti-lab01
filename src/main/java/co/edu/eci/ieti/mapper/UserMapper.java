package co.edu.eci.ieti.mapper;

import co.edu.eci.ieti.data.User;
import co.edu.eci.ieti.dto.UserDto;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        return new User(null,
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getCreatedAt()
        );
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getCreateAt()
        );
    }

}
