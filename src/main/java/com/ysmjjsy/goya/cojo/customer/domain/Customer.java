package com.ysmjjsy.goya.cojo.customer.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaEntity;
import com.ysmjjsy.goya.cojo.constant.enums.Gender;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:32
 */
@Data
@Entity
@Table(name = "t_customer")
public class Customer extends BaseJpaEntity implements UserDetails {
    @Serial
    private static final long serialVersionUID = 8517289830422440854L;

    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private String username;

    @Column(
            nullable = false,
            unique = true,
            length = 15
    )
    private String phone;

    @Column(
            unique = true,
            length = 20
    )
    private String email;

    @Column(
            nullable = false,
            length = 20
    )
    private String password;

    @Column(
            nullable = false,
            length = 20
    )
    private String nickName;

    @Column(
            nullable = false,
            length = 1
    )
    private Gender gender;

    @Column(
            nullable = false
    )
    private LocalDate birthday;

    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private String openId;

    @ManyToMany
    @JoinTable(
            name = "a_customer_role",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
