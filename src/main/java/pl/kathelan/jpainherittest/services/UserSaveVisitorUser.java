package pl.kathelan.jpainherittest.services;

import org.modelmapper.ModelMapper;
import pl.kathelan.jpainherittest.UserRepository;
import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.entities.User;

public class UserSaveVisitorUser implements UserDtoVisitor<UserDto, UserDto, User> {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserSaveVisitorUser(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto visit(UserDto dto, Class<? extends User> entityClass, Class<? extends UserDto> dtoClass) {
        return saveAndReturnDto(dto, entityClass, dtoClass);
    }

    private UserDto saveAndReturnDto(UserDto userDto, Class<? extends User> userClass, Class<? extends UserDto> userDtoClass) {
        User user = modelMapper.map(userDto, userClass);
        User savedRepo = userRepository.save(user);
        return modelMapper.map(savedRepo, userDtoClass);
    }
}
