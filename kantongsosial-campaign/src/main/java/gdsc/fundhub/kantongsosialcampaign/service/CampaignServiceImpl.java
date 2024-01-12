package gdsc.fundhub.kantongsosialcampaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignDescryptionRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignPJRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadAllCampaignDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.read.ReadCampaignDTO;
import gdsc.fundhub.kantongsosialcampaign.model.Campaign;
import gdsc.fundhub.kantongsosialcampaign.model.Category;
import gdsc.fundhub.kantongsosialcampaign.repository.CampaignDb;
import gdsc.fundhub.kantongsosialcampaign.repository.CategoryDb;

import java.util.*;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignDb campaignDb;

    @Autowired
    CategoryDb categoryDb;

    @Override
    public UUID createCampaign(CreateCampaignRequestDTO createCampaignRequestDTO) {
        Campaign campaign = new Campaign();
        campaign.setKomunitas(createCampaignRequestDTO.getKomunitas());
        campaign.setLokasi(createCampaignRequestDTO.getLokasi());
        campaign.setProgram(createCampaignRequestDTO.getProgram());
        campaign.setDana(createCampaignRequestDTO.getDana());
        campaign.setDeadline(createCampaignRequestDTO.getDeadline());
        Optional<Category> category = categoryDb.findById(createCampaignRequestDTO.getCategory());
        campaign.setCategory(category.get());
        campaignDb.save(campaign);
        return campaign.getId();
    }

    @Override
    public UUID createDeskripsi(CreateCampaignDescryptionRequestDTO campaignDescryptionRequestDTO) {
        Optional<Campaign> campaign = campaignDb.findById(campaignDescryptionRequestDTO.getUuid());

        if (campaign.isPresent()) {
            Campaign campaign2 = campaign.get();
            campaign2.setAcara(campaignDescryptionRequestDTO.getAcara());
            campaign2.setCta(campaignDescryptionRequestDTO.getCta());
            campaign2.setIdentitas(campaignDescryptionRequestDTO.getIdentitas());
            campaign2.setJudul(campaignDescryptionRequestDTO.getJudul());
            campaign2.setMasalah(campaignDescryptionRequestDTO.getPenerima());
            campaign2.setPenerima(campaignDescryptionRequestDTO.getPenerima());
            campaign2.setProfil(campaignDescryptionRequestDTO.getProfil());
            campaignDb.save(campaign2);
            return campaign2.getId();
        } else {
            return null;
        }

    }

    @Override
    public UUID createPenJa(CreateCampaignPJRequestDTO createCampaignPJRequestDTO) {
        Optional<Campaign> campaign = campaignDb.findById(createCampaignPJRequestDTO.getUuid());
          if (campaign.isPresent()) {
            Campaign campaign2 = campaign.get();
            campaign2.setNoHp(createCampaignPJRequestDTO.getNoHp());
            campaign2.setNoKtp(createCampaignPJRequestDTO.getNoKtp());
            campaign2.setPekerjaan(createCampaignPJRequestDTO.getPekerjaan());
            campaign2.setAkunMedsos(createCampaignPJRequestDTO.getAkunMedsos());
            campaignDb.save(campaign2);
            return campaign2.getId();
          } else {
            return null;
          }
    }

    @Override
    public ReadCampaignDTO readCampaign(UUID id) {
       ReadCampaignDTO readCampaignDTO = new ReadCampaignDTO();
        Optional<Campaign> campaign = campaignDb.findById(id);
        if (campaign.isPresent()) {
            Campaign campaign2 = campaign.get();
            readCampaignDTO.setAcara(campaign2.getAcara());
            readCampaignDTO.setAkunMedsos(campaign2.getAkunMedsos());
            readCampaignDTO.setBalance(campaign2.getBalance());
            readCampaignDTO.setCta(campaign2.getCta());
            readCampaignDTO.setDana(campaign2.getDana());
            readCampaignDTO.setDeadline(campaign2.getDeadline());
            readCampaignDTO.setIdentitas(campaign2.getIdentitas());
            readCampaignDTO.setJudul(campaign2.getJudul());
            readCampaignDTO.setKomunitas(campaign2.getKomunitas());
            readCampaignDTO.setLokasi(campaign2.getLokasi());
            readCampaignDTO.setMasalah(campaign2.getMasalah());
            readCampaignDTO.setPenerima(campaign2.getPenerima());
            readCampaignDTO.setProfil(campaign2.getProfil());
            readCampaignDTO.setProgram(campaign2.getProgram());
            return readCampaignDTO;
        } else {
            return  null;
        }
    }

    @Override
    public List<ReadAllCampaignDTO> getAllCampaign() {
        List<Campaign> campaigns = campaignDb.findAll();
        List<ReadAllCampaignDTO> readAllCampaignDTOs = new ArrayList<>();

        for(Campaign campaign : campaigns) {
            ReadAllCampaignDTO readAllCampaignDTO = new ReadAllCampaignDTO();
            readAllCampaignDTO.setProgram(campaign.getProgram());
            readAllCampaignDTO.setBalance(campaign.getBalance());
            readAllCampaignDTO.setCategory(campaign.getCategory().getCategory());
            readAllCampaignDTO.setDeadline(campaign.getDeadline());
            readAllCampaignDTOs.add(readAllCampaignDTO);
        }

        return readAllCampaignDTOs;
    }

}
