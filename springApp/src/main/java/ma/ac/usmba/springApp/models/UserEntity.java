package ma.ac.usmba.springApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;


    @ManyToMany
    @JoinTable(name = "user_Roles", joinColumns = @JoinColumn(name = "userId")
    , inverseJoinColumns =@JoinColumn(name = "roleId") )
    private List<RoleEntity> roles;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile profile;
}
