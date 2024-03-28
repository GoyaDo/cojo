package com.ysmjjsy.goya.cojo.role.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaEntity;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.List;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:32
 */
@Data
@Entity
@Table(name = "t_role")
public class Role extends BaseJpaEntity implements GrantedAuthority {
    @Serial
    private static final long serialVersionUID = 8517289830422440854L;

    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private String roleName;

    @Column(
            nullable = false,
            unique = true,
            length = 15
    )
    private String roleCode;

    @ManyToMany(mappedBy = "roles")
    private List<Customer> customers;


    @Override
    public String getAuthority() {
        return this.roleCode;
    }
}
