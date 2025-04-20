package ma.ac.usmba.springApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factureClient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FactureEntity implements Serializable {
    @Id
    private Integer id ;
    @Column(nullable=false, unique=true,name = "referance")
    private String ref;
    @Column(nullable=false,  name = "DateCreationfacture")
    private Date date;
    @ManyToOne
    private ClientEntity client;
    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;



}
