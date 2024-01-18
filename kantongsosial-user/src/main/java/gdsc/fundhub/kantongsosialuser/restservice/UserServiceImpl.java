package gdsc.fundhub.kantongsosialuser.restservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialuser.dto.read.ReadUserDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.CreateUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.LoginUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.model.UserModel;
import gdsc.fundhub.kantongsosialuser.repository.UserDb;
import gdsc.fundhub.kantongsosialuser.security.jwt.JwtUtils;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDb userDb;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userDb.findByUsername(username);
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(new SimpleGrantedAuthority("user"));
        return new User(user.getUsername(), user.getPassword(), grantedAuthority);
    }


    @Override
    public String login(LoginUserRequestDTO loginUserRequestDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String username = loginUserRequestDTO.getUsername();
        UserModel user = userDb.findByUsername(username);
        if (user == null) {
            return null;
        }
        if (passwordEncoder.matches(loginUserRequestDTO.getPassword(), user.getPassword())) {
             return jwtUtils.generateJwtToken(loginUserRequestDTO.getUsername());
        } else {
            return null;
        }
       

    }

    @Override
    public String register(CreateUserRequestDTO createUserRequestDTO) {
        String username = createUserRequestDTO.getUsername();
        UserModel user = userDb.findByUsername(username);

        if (user == null ) {
            user = new UserModel();
            user.setUsername(createUserRequestDTO.getUsername());
            user.setEmail(createUserRequestDTO.getEmail());
            user.setPassword(encrypt(createUserRequestDTO.getPassword()));
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setDateOfBirth(dateFormat.parse(createUserRequestDTO.getDateOfBirth()));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            user.setFirstName(createUserRequestDTO.getFirstName());
            user.setLastName(createUserRequestDTO.getLastName());
            userDb.save(user);
        }

        return jwtUtils.generateJwtToken(createUserRequestDTO.getUsername());
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


    @Override
    public ReadUserDTO profile(String username) {
        UserModel user = userDb.findByUsername(username);
        ReadUserDTO readUserDTO = new ReadUserDTO();
        readUserDTO.setUsername(username);
        readUserDTO.setEmail(user.getEmail());
        readUserDTO.setDateOfBirth(user.getDateOfBirth());
        readUserDTO.setFirstName(user.getFirstName());
        readUserDTO.setLastName(user.getLastName());
        return readUserDTO;
    }

    
}
