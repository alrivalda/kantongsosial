package gdsc.fundhub.kantongsosialcampaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdsc.fundhub.kantongsosialcampaign.model.Campaign;
import jakarta.transaction.Transactional;
import java.util.UUID;
import java.util.*;


@Transactional
@Repository
public interface CampaignDb extends JpaRepository<Campaign,UUID>{
    Optional<Campaign> findById(UUID id);
}
