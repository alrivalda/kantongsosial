package gdsc.fundhub.kantongsosialuser.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdsc.fundhub.kantongsosialuser.dto.read.ReadUserDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.CreateUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.GetProfileRequestDTO;
import gdsc.fundhub.kantongsosialuser.dto.request.LoginUserRequestDTO;
import gdsc.fundhub.kantongsosialuser.dto.response.JwtResponseDTO;
import gdsc.fundhub.kantongsosialuser.restservice.UserService;

@RestController
@RequestMapping("/api")
public class AuthRestController {

    @Autowired
    UserService userService;

    @PostMapping("/auth/register")
    private ResponseEntity<?> register(@RequestBody CreateUserRequestDTO createSellerDTO) {
        try {
            String jwtToken = userService.register(createSellerDTO);
            if (jwtToken == null) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(new JwtResponseDTO(jwtToken), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth/login")
    private ResponseEntity<?> login(@RequestBody LoginUserRequestDTO loginUserRequestDTO) {
        try {
            String jwtToken = userService.login(loginUserRequestDTO);
            if (jwtToken == null) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(new JwtResponseDTO(jwtToken), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth/profile")
    private ResponseEntity<?> login(@RequestBody GetProfileRequestDTO getProfileRequestDTO) {
        try {
            ReadUserDTO userDTO = userService.profile(getProfileRequestDTO.getUsername());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
