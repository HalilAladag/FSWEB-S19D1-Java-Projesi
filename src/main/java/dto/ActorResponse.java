package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
}
