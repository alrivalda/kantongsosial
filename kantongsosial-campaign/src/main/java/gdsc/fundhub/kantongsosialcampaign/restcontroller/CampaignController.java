package gdsc.fundhub.kantongsosialcampaign.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdsc.fundhub.kantongsosialcampaign.dto.Request.CampaignDetailRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignDescryptionRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignPJRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadAllCampaignDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadCampaignDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.response.CreateCampaignResponse;
import gdsc.fundhub.kantongsosialcampaign.model.Category;
import gdsc.fundhub.kantongsosialcampaign.service.CampaignService;
import java.util.*;
@RestController
@RequestMapping("/api")
public class CampaignController {
    
    @Autowired
    CampaignService campaignService;

    @PostMapping("/campaign/create")
    private ResponseEntity<?> createCampaign(@RequestBody CreateCampaignRequestDTO createCampaignRequestDTO) {
        try {
            UUID uuid = campaignService.createCampaign(createCampaignRequestDTO);
            return new ResponseEntity<>(new CreateCampaignResponse(uuid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/campaign/create-descryption")
    private ResponseEntity<?> createDescryption(@RequestBody CreateCampaignDescryptionRequestDTO createCampaignRequestDTO) {
        try {
            UUID uuid = campaignService.createDeskripsi(createCampaignRequestDTO);
            return new ResponseEntity<>(new CreateCampaignResponse(uuid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

      @PostMapping("/campaign/create-penja")
    private ResponseEntity<?> createpenja(@RequestBody CreateCampaignPJRequestDTO createCampaignPJRequestDTO) {
        try {
            UUID uuid = campaignService.createPenJa(createCampaignPJRequestDTO);
            return new ResponseEntity<>(new CreateCampaignResponse(uuid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/campaign/detail")
    private ResponseEntity<?> createpenja(@RequestBody CampaignDetailRequestDTO campaignDetailRequestDTO) {
        try {
            ReadCampaignDTO readCampaignDTO  = campaignService.readCampaign(campaignDetailRequestDTO.getId());
            return new ResponseEntity<>(readCampaignDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/all-campaign")
    private ResponseEntity<?> getAllCategory() {
        try {
            List<ReadAllCampaignDTO> readAllCampaignDTOs = campaignService.getAllCampaign();
            return new ResponseEntity<>(readAllCampaignDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
