package it.sysagent.recommended.recordingwebapp.controller;

import it.sysagent.recommended.recordingwebapp.controller.converter.UserConverter;
import it.sysagent.recommended.recordingwebapp.controller.dto.UserDTO;
import it.sysagent.recommended.recordingwebapp.document.User;
import it.sysagent.recommended.recordingwebapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final UserConverter userConverter = Mockito.mock(UserConverter.class);

    @Spy
    private UserController userController = new UserController(userService, userConverter);


    @Test
    public void createUserReturnsCreatedStatusAndUserId() {
        UserDTO userDTO = new UserDTO("name", 15, Boolean.TRUE, "male", "email");
        UUID uuid = UUID.randomUUID();

        when(userConverter.convertFromUserDTO(userDTO)).thenCallRealMethod();
        when(userService.save(Mockito.any(User.class))).thenReturn(uuid);

        ResponseEntity<UUID> response = userController.createUser(userDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(uuid, response.getBody());
    }

    @Test
    public void getUserReturnsOkStatusAndUser() {
        UUID uuid = UUID.randomUUID();
        User user = Mockito.mock(User.class);

        when(userService.findById(uuid)).thenReturn(user);

        ResponseEntity<User> response = userController.getUser(uuid);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }
}