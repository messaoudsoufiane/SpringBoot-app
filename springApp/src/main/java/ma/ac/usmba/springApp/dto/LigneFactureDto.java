package ma.ac.usmba.springApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneFactureDto {
    private String refProduit;
    private Integer quantite;
}
