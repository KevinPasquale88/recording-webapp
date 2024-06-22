package it.sys.agent.recommended.recording.webapp.service;

import it.sys.agent.recommended.recording.webapp.document.User;
import it.sys.agent.recommended.recording.webapp.repository.UserRepository;
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
