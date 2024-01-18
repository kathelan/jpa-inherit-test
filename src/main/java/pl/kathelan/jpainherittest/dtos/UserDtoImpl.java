package pl.kathelan.jpainherittest.dtos;

import pl.kathelan.jpainherittest.services.UserDtoVisitor;

public class UserDtoImpl extends UserDto {
    @Override
    public <T> T accept(UserDtoVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
