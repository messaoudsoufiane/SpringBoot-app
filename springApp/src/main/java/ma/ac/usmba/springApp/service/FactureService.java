package ma.ac.usmba.springApp.service;

import ma.ac.usmba.springApp.models.FactureEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FactureService {
    FactureEntity save(FactureEntity facture);
    List<FactureEntity> findAll();

    FactureEntity findByRef(String ref);

    Optional<FactureEntity> findById(Integer id);
}
