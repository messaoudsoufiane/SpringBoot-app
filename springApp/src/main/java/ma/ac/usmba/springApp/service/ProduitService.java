package ma.ac.usmba.springApp.service;

import ma.ac.usmba.springApp.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

    ProduitDto save(ProduitDto produitDto);
    int delete(String ref );
    ProduitDto update( ProduitDto produitDto);
    ProduitDto findByRef(String ref);
    List<ProduitDto> findAll();
}
