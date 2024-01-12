package gdsc.fundhub.kantongsosialfe.restservice;

import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialfe.dto.request.LoginDTO;
import gdsc.fundhub.kantongsosialfe.dto.response.JwtResponseDTO;

@Service
public interface UserRestService {
    JwtResponseDTO Login(LoginDTO loginDTO);
}
