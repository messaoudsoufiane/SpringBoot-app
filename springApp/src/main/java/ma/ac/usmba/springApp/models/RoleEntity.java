package ma.ac.usmba.springApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable {
    @Id
    private Integer roleId;
    @Column(nullable = false)
    private String roleName;

    @ManyToMany
    @JoinTable(name = "user_Roles", joinColumns = @JoinColumn(name = "roleId")
            , inverseJoinColumns =@JoinColumn(name = "userId") )
    private List<RoleEntity> roles;
}
