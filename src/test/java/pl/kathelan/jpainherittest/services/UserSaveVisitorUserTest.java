package pl.kathelan.jpainherittest.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import pl.kathelan.jpainherittest.UserRepository;
import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.dtos.UserDtoImpl;
import pl.kathelan.jpainherittest.entities.User;
import pl.kathelan.jpainherittest.services.UserSaveVisitorUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserSaveVisitorUserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserSaveVisitorUser userSaveVisitorUser;

    private UserDtoImpl userDto;
    private User user;

    @BeforeEach
    public void setUp() {
        userDto = new UserDtoImpl();
        // set properties for userDto as needed
        user = new User();
        // set properties for user as needed
    }

    @Test
    void testSaveAndReturnDto() {
        when(modelMapper.map(userDto, User.class)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(modelMapper.map(user, UserDtoImpl.class)).thenReturn(userDto);

        UserDto result = userSaveVisitorUser.visit(userDto, User.class, UserDtoImpl.class);

        verify(modelMapper, times(2)).map(any(), any());
        verify(userRepository, times(1)).save(any(User.class));
        assertThat(result).isNotNull();
        // add more assertions as per your needs
    }
}


