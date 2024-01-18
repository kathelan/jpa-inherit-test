package pl.kathelan.jpainherittest.services;

import org.modelmapper.ModelMapper;
import pl.kathelan.jpainherittest.UserRepository;
import pl.kathelan.jpainherittest.dtos.ExtendedUserDto;
import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.dtos.UserDtoImpl;
import pl.kathelan.jpainherittest.entities.ExtendedUser;
import pl.kathelan.jpainherittest.entities.User;

public class UserSaveVisitor implements UserDtoVisitor<UserDto> {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserSaveVisitor(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDtoImpl visit(UserDtoImpl userDto) {
        return saveAndReturnDto(userDto, User.class, UserDtoImpl.class);
    }

    @Override
    public ExtendedUserDto visit(ExtendedUserDto extendedUserDto) {
        return saveAndReturnDto(extendedUserDto, ExtendedUser.class, ExtendedUserDto.class);
    }

    private <T extends UserDto, U extends User> T saveAndReturnDto(T userDto, Class<U> userClass, Class<T> userDtoClass) {
        U user = modelMapper.map(userDto, userClass);
        U savedRepo = userRepository.save(user);
        return modelMapper.map(savedRepo, userDtoClass);
    }
}
