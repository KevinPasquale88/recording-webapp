package it.sysagent.recommended.recordingwebapp.controller.converter;

import it.sysagent.recommended.recordingwebapp.controller.dto.UserDTO;
import it.sysagent.recommended.recordingwebapp.document.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserConverterTest {


    UserConverter userConverter = new UserConverter();

    @Test
    public void convertFromUserDTOCreatesUserWithSameAttributes() {
        UserDTO userDTO = new UserDTO("John Doe", 30, true, "Male", "john.doe@example.com");

        User user = userConverter.convertFromUserDTO(userDTO);

        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getAge(), user.getAge());
        assertEquals(userDTO.isPermit(), user.isPermit());
        assertEquals(userDTO.getGender(), user.getGender());
        assertEquals(userDTO.getEmail(), user.getEmail());
    }

    @Test
    public void convertFromUserCreatesUserDTOWithSameAttributes() {
        User user = new User(UUID.randomUUID(), "John Doe", "john.doe@example.com", "Male", 30, true);

        UserDTO userDTO = userConverter.convertFromUser(user);

        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getAge(), userDTO.getAge());
        assertEquals(user.isPermit(), userDTO.isPermit());
        assertEquals(user.getGender(), userDTO.getGender());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }
}