package it.sys.agent.recommended.recording.webapp.controller.converter;


import it.sys.agent.recommended.recording.webapp.controller.dto.UserDTO;
import it.sys.agent.recommended.recording.webapp.document.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserConverter {



    public User convertFromUserDTO(UserDTO userDTO) {
        return Optional.ofNullable(userDTO)
                .map(this::convert)
                .orElse(User.builder().build());
    }

    public UserDTO convertFromUser(User user) {
        return Optional.ofNullable(user)
                .map(this::convert)
                .orElse(UserDTO.builder().build());
    }

    protected UserDTO convert(User user) {
        return UserDTO.builder()
                .age(user.getAge())
                .email(user.getEmail())
                .name(user.getName())
                .permit(user.isPermit())
                .gender(user.getGender())
                .build();
    }

    protected User convert(UserDTO userDTO) {
        return User.builder()
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .permit(userDTO.isPermit())
                .id(UUID.randomUUID())
                .gender(userDTO.getGender())
                .build();
    }
}