package gdsc.fundhub.kantongsosialuser.dto.read;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadUserDTO {
    private String username;
    private String email;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
}
