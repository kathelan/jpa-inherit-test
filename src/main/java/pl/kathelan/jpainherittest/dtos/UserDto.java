package pl.kathelan.jpainherittest.dtos;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import pl.kathelan.jpainherittest.entities.User;
import pl.kathelan.jpainherittest.services.UserDtoVisitor;

@Setter
@Getter
@RequiredArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserDtoImpl.class, name = "USER"),
        @JsonSubTypes.Type(value = ExtendedUserDto.class, name = "EXTENDED_USER")
})
public abstract class UserDto {
    public enum UserType {
        USER, EXTENDED_USER
    }
    private String firstName;
    private String lastName;
    private UserDto.UserType type;

    public abstract <T> T accept(UserDtoVisitor<T, UserDto, User> visitor);
}
