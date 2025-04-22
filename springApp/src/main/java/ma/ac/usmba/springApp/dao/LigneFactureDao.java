package ma.ac.usmba.springApp.dao;

import ma.ac.usmba.springApp.models.LignFactureKey;
import ma.ac.usmba.springApp.models.LigneFactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LignFactureKey> {
    List<LigneFactureEntity> findAllByFactureId(Integer factureId);
}
