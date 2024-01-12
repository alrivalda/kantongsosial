package gdsc.fundhub.kantongsosialuser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequestDTO {
    private String username;
    private String password;
}
