package com.vvieira.app.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nome_user",length = 50)
    private String nome;

    @Column(name="email",length = 40,unique = true)
    private String email;

    @Column(name="username",length = 30,unique = true)
    private String username;

    @Column(name="password_user",length = 100)
    private String password;

    @Column(name="active_from")
    private LocalDate active_from;

    @Column(name="profile_photo")
    private String profile_photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Perfil> perfils = new HashSet<>();
}
