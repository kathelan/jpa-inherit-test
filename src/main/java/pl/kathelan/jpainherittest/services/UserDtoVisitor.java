package pl.kathelan.jpainherittest.services;

import pl.kathelan.jpainherittest.dtos.ExtendedUserDto;
import pl.kathelan.jpainherittest.dtos.UserDto;

public interface UserDtoVisitor<T> {
    T visit(UserDto userDto);
    T visit(ExtendedUserDto extendedUserDto);
}

