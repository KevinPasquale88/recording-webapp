package it.sys.agent.recommended.recording.webapp.controller.dto;


import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDTO {

    String name;

    @Positive
    Integer age;

    boolean permit;
    String gender;
    String email;

    @Builder
    public UserDTO(String name, Integer age, boolean permit, String gender, String email) {
        this.name = name;
        this.age = age;
        this.permit = permit;
        this.email = email;
        this.gender = gender;
    }
}
