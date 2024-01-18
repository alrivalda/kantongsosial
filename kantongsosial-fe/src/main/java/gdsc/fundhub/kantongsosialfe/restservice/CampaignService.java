package gdsc.fundhub.kantongsosialfe.restservice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import gdsc.fundhub.kantongsosialfe.dto.request.CampaignDetailRequestDTO;
import gdsc.fundhub.kantongsosialfe.dto.response.CampaignDTO;
import gdsc.fundhub.kantongsosialfe.dto.response.JwtResponseDTO;

@Service
public class CampaignService {
       private final WebClient webClient;

    public CampaignService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public CampaignDTO getCampaignDTO(CampaignDetailRequestDTO campaignDetailRequestDTO){
        var response = this.webClient.post().uri("/api/campaign/detail").bodyValue(campaignDetailRequestDTO).retrieve()
                .bodyToMono(CampaignDTO.class).block();
        
       return  response;
    }

}
