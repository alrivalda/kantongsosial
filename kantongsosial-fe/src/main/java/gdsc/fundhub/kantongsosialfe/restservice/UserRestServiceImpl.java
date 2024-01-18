package gdsc.fundhub.kantongsosialfe.restservice;

import org.springframework.web.reactive.function.client.WebClient;

import gdsc.fundhub.kantongsosialfe.dto.request.LoginDTO;
import gdsc.fundhub.kantongsosialfe.dto.request.RegisterDTO;
import gdsc.fundhub.kantongsosialfe.dto.response.JwtResponseDTO;
import gdsc.fundhub.kantongsosialfe.security.jwt.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;


@Service
public class UserRestServiceImpl implements UserRestService {

    private final WebClient webClient;

    public UserRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public JwtResponseDTO Login(LoginDTO loginDTO) {
        var response = this.webClient.post().uri("/api/auth/login").bodyValue(loginDTO).retrieve()
                .bodyToMono(JwtResponseDTO.class).block();
        
       return  response;

    }

    @Override
    public JwtResponseDTO register(RegisterDTO registerDTO) {
        var response = this.webClient.post().uri("/api/auth/register").bodyValue(registerDTO).retrieve()
                .bodyToMono(JwtResponseDTO.class).block();
        
       return  response;
    }

}
