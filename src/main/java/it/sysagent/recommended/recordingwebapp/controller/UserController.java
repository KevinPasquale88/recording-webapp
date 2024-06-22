package it.sysagent.recommended.recordingwebapp.controller;

import it.sysagent.recommended.recordingwebapp.controller.converter.UserConverter;
import it.sysagent.recommended.recordingwebapp.controller.dto.UserDTO;
import it.sysagent.recommended.recordingwebapp.document.User;
import it.sysagent.recommended.recordingwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;
private final UserConverter userConverter;

    @Autowired
    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UUID> createUser(@RequestBody UserDTO userDTO) {
        User user = userConverter.convertFromUserDTO(userDTO);
        UUID createdId = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdId);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
