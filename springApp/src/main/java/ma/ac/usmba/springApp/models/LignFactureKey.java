package ma.ac.usmba.springApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class LignFactureKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "facture_id")
    private Integer factureId ;
    @Column(name="produit_id")
    private Integer produitId ;


}
