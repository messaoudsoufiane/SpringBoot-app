package ma.ac.usmba.springApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String avatar ;

    private String telephone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
