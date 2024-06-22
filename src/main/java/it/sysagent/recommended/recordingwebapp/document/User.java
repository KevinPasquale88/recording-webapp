package it.sysagent.recommended.recordingwebapp.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class User {

    @Id
    UUID id;

    String name;
    String email;
    String gender;
    Integer age;
    boolean permit;

    @Builder
    public User(UUID id, String name, String email, String gender, Integer age, boolean permit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.permit = permit;
    }

}
