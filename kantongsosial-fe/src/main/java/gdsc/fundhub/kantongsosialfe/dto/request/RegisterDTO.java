package gdsc.fundhub.kantongsosialfe.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
}
