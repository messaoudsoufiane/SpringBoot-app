package ma.ac.usmba.springApp.service;

import lombok.RequiredArgsConstructor;
import ma.ac.usmba.springApp.dao.FactureDao;
import ma.ac.usmba.springApp.models.FactureEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Injection automatique des champs final
public class FactureServiceImpl implements FactureService {

    private final FactureDao factureDao; // Champ marqué comme final pour injection

    @Override
    public FactureEntity findByRef(String ref) {
        return factureDao.findByRef(ref)
                .orElseThrow(() -> new RuntimeException("Facture non trouvée avec la référence : " + ref));
    }

    @Override
    public Optional<FactureEntity> findById(Integer id) {
        return factureDao.findById(id);
    }

    @Override
    public FactureEntity save(FactureEntity factureEntity) {
        if (factureEntity == null) {
            throw new IllegalArgumentException("La facture ne peut pas être nulle");
        }
        return factureDao.save(factureEntity);
    }

    @Override
    public List<FactureEntity> findAll() {
        return factureDao.findAll();
    }
}