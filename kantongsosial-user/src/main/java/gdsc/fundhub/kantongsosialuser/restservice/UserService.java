package gdsc.fundhub.kantongsosialuser.restservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialuser.dto.read.ReadUserDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.CreateUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.LoginUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.model.UserModel;

@Service
public interface UserService {
    String login(LoginUserRequestDTO loginUserRequestDTO);
    String register(CreateUserRequestDTO createUserRequestDTO);
    String encrypt(String password);
    UserDetails loadUserByUsername(String username);
    ReadUserDTO profile(String username);
}
