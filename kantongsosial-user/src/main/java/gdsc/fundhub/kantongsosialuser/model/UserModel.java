package gdsc.fundhub.kantongsosialuser.model;


import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserModel implements UserDetails{
    
    @Id
    @Column(name = "user_id")
    @NotNull
    private UUID id = UUID.randomUUID();

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

     @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @NotNull
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "email" , unique = true)
    private String email;

    @Column(name = "dateOfBirth", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
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
