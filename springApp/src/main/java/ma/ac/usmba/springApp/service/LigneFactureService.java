package ma.ac.usmba.springApp.service;

import ma.ac.usmba.springApp.models.LigneFactureEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LigneFactureService {

    LigneFactureEntity save(LigneFactureEntity ligneFacture);

    List<LigneFactureEntity> findAll();
}

