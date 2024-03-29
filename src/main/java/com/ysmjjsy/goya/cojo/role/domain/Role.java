package com.ysmjjsy.goya.cojo.role.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaEntity;
import com.ysmjjsy.goya.cojo.customer.domain.Customer;
import com.ysmjjsy.goya.cojo.permissions.domain.Permissions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Set;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:32
 */
@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseJpaEntity {
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

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "a_role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permissions_id"))
    private Set<Permissions> permissions;

}
