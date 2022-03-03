package com.vvieira.app.auth;

import com.vvieira.app.security.entity.Usuario;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserDetailsEntity implements UserDetails {

    private Long id;
    private String password;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsEntity(Usuario usuario){
        this.id = usuario.getId();
        this.password = usuario.getPassword();
        this.username = usuario.getUsername();
        this.authorities = usuario.getPerfils();
    }

    public String getUsername(){
        return this.username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}