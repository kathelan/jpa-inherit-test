package pl.kathelan.jpainherittest.services;

import pl.kathelan.jpainherittest.dtos.ExtendedUserDto;
import pl.kathelan.jpainherittest.dtos.UserDtoImpl;

public interface UserDtoVisitor<T> {
    T visit(UserDtoImpl userDto);
    T visit(ExtendedUserDto extendedUserDto);
}

