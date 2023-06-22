package com.institutsaintjean.GestionsDesInterventions.config;

import com.institutsaintjean.GestionsDesInterventions.entities.Personnel;
import com.institutsaintjean.GestionsDesInterventions.entities.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeDetails implements UserDetails {

    private String nomEmp;
    private String password;
    private List<GrantedAuthority> authorities;

    public EmployeDetails(Utilisateur utilisateur) {
        nomEmp= utilisateur.getEmail();
        password= utilisateur.getMot_de_passe();
        authorities= Arrays.stream(utilisateur.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nomEmp;
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
