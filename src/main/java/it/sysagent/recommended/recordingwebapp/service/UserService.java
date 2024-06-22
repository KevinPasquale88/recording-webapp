package it.sysagent.recommended.recordingwebapp.service;

import it.sysagent.recommended.recordingwebapp.document.User;
import it.sysagent.recommended.recordingwebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository _userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public UUID save(User user) {
       return _userRepository.save(user).getId();
    }


    public User findById(UUID id) {
        return _userRepository.findById(id).orElseThrow();
    }
}
