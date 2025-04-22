package ma.ac.usmba.springApp.dao;

import ma.ac.usmba.springApp.models.FactureEntity;
import ma.ac.usmba.springApp.models.LignFactureKey;
import ma.ac.usmba.springApp.models.LigneFactureEntity;
import ma.ac.usmba.springApp.models.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactureDao extends JpaRepository< FactureEntity, Integer> {
    Optional<FactureEntity> findByRef(String ref);

}
