package pl.kathelan.jpainherittest.dtos;

import lombok.*;
import pl.kathelan.jpainherittest.services.UserDtoVisitor;

//@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@RequiredArgsConstructor
public class ExtendedUserDto extends UserDto {
    private String thirdName;

    @Override
    public <T> T accept(UserDtoVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
