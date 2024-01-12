package gdsc.fundhub.kantongsosialcampaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdsc.fundhub.kantongsosialcampaign.model.Category;
import jakarta.transaction.Transactional;
import java.util.*;


@Transactional
@Repository
public interface CategoryDb extends JpaRepository<Category,Long> {
    Optional<Category> findById(long id);

}
