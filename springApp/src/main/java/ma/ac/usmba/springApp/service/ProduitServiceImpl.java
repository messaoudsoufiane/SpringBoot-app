package ma.ac.usmba.springApp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.ac.usmba.springApp.dao.ProduitDao;
import ma.ac.usmba.springApp.dto.ProduitDto;
import ma.ac.usmba.springApp.models.ProduitEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitDao produitDao;
    private final ModelMapper modelMapper;

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        if(findByRef(produitDto.getRef()) != null) {
            return null;
        }

        ProduitEntity produitEntity = modelMapper.map(produitDto, ProduitEntity.class);
        // Ne pas définir l'ID manuellement ici
        ProduitEntity savedProduit = produitDao.save(produitEntity);
        return modelMapper.map(savedProduit, ProduitDto.class);
    }
    @Transactional
    @Override
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<ProduitEntity>  produitEntity =produitDao.findByRef(produitDto.getRef());
        if(produitEntity.isEmpty()) return null;
        update(produitEntity.get(),produitDto);
        ProduitEntity saved=produitDao.save(produitEntity.get());
        return modelMapper.map(saved, ProduitDto.class);
    }

    @Override
    public ProduitDto findByRef(String ref) {
        ProduitEntity produitEntity=produitDao.findByRef(ref).orElse(null);
        if(produitEntity==null) return null;
        return modelMapper.map(produitEntity,ProduitDto.class);
    }

    private void update(ProduitEntity produitEntity , ProduitDto produitDto) {
        produitEntity.setLibelle(produitDto.getLibelle());
        produitEntity.setPrix(produitDto.getPrix());
        produitEntity.setQuantiteStock(produitDto.getQuantiteStock());

    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll().stream().map(el-> modelMapper.map(el, ProduitDto.class)).collect(Collectors.toList());
    }
}

