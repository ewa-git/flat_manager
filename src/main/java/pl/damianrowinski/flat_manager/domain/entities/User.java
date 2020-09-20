package pl.damianrowinski.flat_manager.domain.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.damianrowinski.flat_manager.security.Role;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Getter
@Setter
@Transactional
@Table(name = User.TABLE_NAME)
public class User extends BaseEntityPersonalDetails {
    final static String TABLE_NAME = "users";


    @NotNull
    private String login;

    @NotNull
    private String password;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    private Role role;
}
