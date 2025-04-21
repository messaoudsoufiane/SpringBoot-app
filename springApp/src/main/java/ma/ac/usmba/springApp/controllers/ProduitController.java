package ma.ac.usmba.springApp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.ac.usmba.springApp.dto.ProduitDto;
import ma.ac.usmba.springApp.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping("/")
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @PutMapping("/")
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.update(produitDto);
    }

    @GetMapping("/ref/{ref}")
    public ProduitDto findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }
    @GetMapping("/")
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }
}