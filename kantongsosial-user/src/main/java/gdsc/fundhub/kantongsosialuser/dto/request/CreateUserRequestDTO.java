package gdsc.fundhub.kantongsosialuser.dto.request;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDTO {
    private String username;
    private String password;
    private String email;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
}
