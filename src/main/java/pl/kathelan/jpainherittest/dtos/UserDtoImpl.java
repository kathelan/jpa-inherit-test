package pl.kathelan.jpainherittest.dtos;

import pl.kathelan.jpainherittest.entities.User;
import pl.kathelan.jpainherittest.services.UserDtoVisitor;

public class UserDtoImpl extends UserDto {
    @Override
    public <T> T accept(UserDtoVisitor<T, UserDto, User> visitor) {
        return visitor.visit(this, User.class, UserDtoImpl.class);
    }
}
