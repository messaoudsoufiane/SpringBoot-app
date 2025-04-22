package ma.ac.usmba.springApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LignFactureKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "facture_id", nullable = false)
    private Integer factureId;

    @Column(name = "produit_id", nullable = false)
    private Integer produitId;

    // Constructeur personnalisé pour une création facile
    public static LignFactureKey of(Integer factureId, Integer produitId) {
        return new LignFactureKey(factureId, produitId);
    }

    // Validation des champs
    public boolean isValid() {
        return factureId != null && produitId != null;
    }
}