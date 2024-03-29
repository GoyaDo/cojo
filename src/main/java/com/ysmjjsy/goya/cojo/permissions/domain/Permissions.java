package com.ysmjjsy.goya.cojo.permissions.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaEntity;
import com.ysmjjsy.goya.cojo.role.domain.Role;
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
@Getter
@Setter
@Entity
@Table(name = "t_permissions")
public class Permissions extends BaseJpaEntity {
    @Serial
    private static final long serialVersionUID = 8517289830422440854L;

    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private String permissionsName;

    @Column(
            nullable = false,
            unique = true,
            length = 15
    )
    private String permissionsCode;

    @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
    private Set<Role> roles;
}
