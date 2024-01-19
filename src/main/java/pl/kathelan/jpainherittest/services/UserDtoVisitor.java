package pl.kathelan.jpainherittest.services;

import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.entities.User;

public interface UserDtoVisitor<R, D extends UserDto, E extends User> {
    R visit(D dto, Class<? extends E> entityClass, Class<? extends D> dtoClass);
}

