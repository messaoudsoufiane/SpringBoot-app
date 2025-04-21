package ma.ac.usmba.springApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {
    private String ref;
    private String libelle;  // Même nom que dans l'entité
    private BigDecimal prix;
    private double quantiteStock;  // Nom cohérent avec l'entité (en camelCase)
}
