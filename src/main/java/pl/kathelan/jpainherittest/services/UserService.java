package pl.kathelan.jpainherittest.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.kathelan.jpainherittest.UserRepository;
import pl.kathelan.jpainherittest.dtos.ExtendedUserDto;
import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.entities.ExtendedUser;
import pl.kathelan.jpainherittest.entities.User;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserDto createUser(UserDto userDto) {
        UserSaveVisitor visitor = new UserSaveVisitor(userRepository, modelMapper);
        return userDto.accept(visitor);
    }
}
