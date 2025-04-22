package ma.ac.usmba.springApp.service;

import lombok.RequiredArgsConstructor;
import ma.ac.usmba.springApp.dao.LigneFactureDao;
import ma.ac.usmba.springApp.models.LigneFactureEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LigneFactureServiceImpl implements LigneFactureService {

    private final LigneFactureDao ligneFactureDao;
    @Override
    public LigneFactureEntity save(LigneFactureEntity ligneFacture) {
        return ligneFactureDao.save(ligneFacture);
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }
}
