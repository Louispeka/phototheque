package org.phototheque.entity;
import jakarta.persistence.*;

/**
 * Entité prenant en charge les utilisateurs.
 *
 * <p>
 *     L'annotation <i>@Entity</i> indique que cette classe est une classe de mapping
 *     entre le mode objet de l'application et la base de données.
 * </p>
 * <p>
 *      L'annotation <i>@Table</i> permet de spécifier le nom de la table à mapper.
 *      Par défaut, le nom de la classe est identique au nom de la table.
 * </p>
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * La propriété <i>id</i> sera associée à la clé primaire de la table <i>users</i>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Prénom de l'utilisateur.
     */
    private String firstname;

    /**
     * Nom de l'utilisateur.
     */
    private String lastname;

    /**
     * Nom d'utilisateur unique pour l'authentification.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Mot de passe hashé de l'utilisateur.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Rôle de l'utilisateur (ex: ROLE_USER, ROLE_ADMIN).
     */
    private String role;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
