package com.laboratoris.retea_socializare_backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
    @Id
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private Section section;
    @Enumerated(EnumType.STRING)
    private Character character;

    public User(String email, String password,
            Section section, Character character) {
        this.email = email;
        this.password = password;
        this.section = section;
        this.character = character;
    }
}
