package gdsc.fundhub.kantongsosialcampaign.service;

import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignDescryptionRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignPJRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadAllCampaignDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadCampaignDTO;
import java.util.*;
import java.util.*;
@Service
public interface CampaignService {
    UUID createCampaign(CreateCampaignRequestDTO createCampaignRequestDTO);
    UUID createDeskripsi(CreateCampaignDescryptionRequestDTO campaignDescryptionRequestDTO);
    UUID createPenJa(CreateCampaignPJRequestDTO createCampaignPJRequestDTO);
    ReadCampaignDTO readCampaign(UUID id);
    List<ReadAllCampaignDTO> getAllCampaign();

}
