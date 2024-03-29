package com.ysmjjsy.goya.cojo.sercurity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author 77394
 * @description TODO
 * @className CustomerUser
 * @date 2024/3/29 9:14
 */
@Data
public class LoginCustomer implements UserDetails {


    @Serial
    private static final long serialVersionUID = 7230308239539702122L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    private Customer customer;

    private Set<Role> roles;

    /**
     * 用户权限集合
     */
    @JsonIgnore
    private List<String> authorityCodes;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorityCodes.forEach(authorityCode->authorities.add(new SimpleGrantedAuthority(authorityCode)));
        return authorities;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getUsername();
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
        return !customer.isLock();
    }

    public LoginCustomer(Customer customer,Set<Role> roles,List<String> authorities){
        this.customer = customer;
        this.roles = roles;
        this.authorityCodes = authorities;
    }
}
