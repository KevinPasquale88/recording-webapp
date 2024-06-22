package it.sysagent.recommended.recordingwebapp.repository;

import it.sysagent.recommended.recordingwebapp.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
}
