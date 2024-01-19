package pl.kathelan.jpainherittest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import pl.kathelan.jpainherittest.dtos.ExtendedUserDto;
import pl.kathelan.jpainherittest.dtos.UserDto;
import pl.kathelan.jpainherittest.dtos.UserDtoImpl;
import pl.kathelan.jpainherittest.services.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    private UserDto userDto;
    private UserDtoImpl userDtoImpl;
    private ExtendedUserDto extendedUserDto;

    @BeforeEach
    public void setUp() {
        userDtoImpl = new UserDtoImpl();
        // Set fields of userDtoImpl as needed

        extendedUserDto = new ExtendedUserDto();
        // Set fields of extendedUserDto as needed
    }

    @Test
    void createUserDtoImpl() throws Exception {
        createUserDtoAndTestResponse(userDtoImpl, UserDtoImpl.class);
    }

    @Test
    void createExtendedUserDto() throws Exception {
        createUserDtoAndTestResponse(extendedUserDto, ExtendedUserDto.class);
    }

    private <T> void createUserDtoAndTestResponse(T userDto, Class<T> responseType) throws Exception {
        String url = "/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(userDto), headers);
        UserDto response = restTemplate.postForObject(url, entity, UserDto.class);

        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(responseType);
        // Add more assertions to check the response values based on respective UserDto properties
    }


}


