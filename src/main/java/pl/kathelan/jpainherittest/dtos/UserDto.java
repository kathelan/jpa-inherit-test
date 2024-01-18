package pl.kathelan.jpainherittest.dtos;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import pl.kathelan.jpainherittest.services.UserDtoVisitor;

@Setter
@Getter
@RequiredArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserDtoImpl.class, name = "userDto"),
        @JsonSubTypes.Type(value = ExtendedUserDto.class, name = "extendedUserDto")
})
public abstract class UserDto {
    private String firstName;
    private String lastName;

    public abstract <T> T accept (UserDtoVisitor<T> visitor);
}
