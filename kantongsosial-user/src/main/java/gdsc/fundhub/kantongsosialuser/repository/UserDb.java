package gdsc.fundhub.kantongsosialuser.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdsc.fundhub.kantongsosialuser.model.UserModel;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface UserDb extends JpaRepository<UserModel,UUID> {
    UserModel findByUsername(String username);
}

