package pl.kathelan.jpainherittest.dtos;

import lombok.*;
import pl.kathelan.jpainherittest.entities.ExtendedUser;
import pl.kathelan.jpainherittest.entities.User;
import pl.kathelan.jpainherittest.services.UserDtoVisitor;

//@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@RequiredArgsConstructor
public class ExtendedUserDto extends UserDto {
    private String thirdName;
    @Override
    public <T> T accept(UserDtoVisitor<T, UserDto, User> visitor) {
        return visitor.visit(this, ExtendedUser.class, ExtendedUserDto.class);
    }
}
