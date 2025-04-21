package ma.ac.usmba.springApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)  // Ajout de unique
    private String ref;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false, name = "quantite_stock")  // Explicit column name
    private double quantiteStock;  // Changement pour camelCase en Java

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;
}
