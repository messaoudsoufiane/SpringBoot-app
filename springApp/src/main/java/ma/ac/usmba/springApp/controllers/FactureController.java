package ma.ac.usmba.springApp.controllers;

import jakarta.validation.Valid;
import ma.ac.usmba.springApp.dto.FactureDto;
import ma.ac.usmba.springApp.models.FactureEntity;
import ma.ac.usmba.springApp.service.FactureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @Autowired
    private ModelMapper modelMapper;

    // Créer une nouvelle facture
    @PostMapping("/")
    public ResponseEntity<FactureDto> createFacture(@Valid @RequestBody FactureDto factureDto) {
        // Mapper le DTO vers l'entité
        FactureEntity factureEntity = modelMapper.map(factureDto, FactureEntity.class);

        // Sauvegarder la facture via le service
        FactureEntity savedFacture = factureService.save(factureEntity);

        // Mapper l'entité sauvegardée vers un DTO pour la réponse
        FactureDto responseDto = modelMapper.map(savedFacture, FactureDto.class);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // Récupérer toutes les factures
    @GetMapping
    public ResponseEntity<List<FactureDto>> getAllFactures() {
        // Récupérer toutes les factures via le service
        List<FactureEntity> factures = factureService.findAll();

        // Mapper les entités vers des DTOs
        List<FactureDto> factureDtos = factures.stream()
                .map(facture -> modelMapper.map(facture, FactureDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(factureDtos, HttpStatus.OK);
    }

    // Récupérer une facture par sa référence
    @GetMapping("/{ref}")
    public ResponseEntity<FactureDto> getFactureByRef(@PathVariable String ref) {
        // Récupérer la facture via le service
        FactureEntity factureEntity = factureService.findByRef(ref);

        // Mapper l'entité vers un DTO
        FactureDto factureDto = modelMapper.map(factureEntity, FactureDto.class);

        return new ResponseEntity<>(factureDto, HttpStatus.OK);
    }

    // Mettre à jour une facture
    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(@PathVariable Integer id, @RequestBody FactureDto factureDto) {
        // Récupérer la facture existante
        FactureEntity existingFacture = factureService.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture non trouvée avec l'ID : " + id));

        // Mapper les données mises à jour depuis le DTO vers l'entité existante
        modelMapper.map(factureDto, existingFacture);

        // Sauvegarder la facture mise à jour
        FactureEntity updatedFacture = factureService.save(existingFacture);

        // Mapper l'entité mise à jour vers un DTO pour la réponse
        FactureDto responseDto = modelMapper.map(updatedFacture, FactureDto.class);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}