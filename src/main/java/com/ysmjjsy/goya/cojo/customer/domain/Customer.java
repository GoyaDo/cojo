package com.ysmjjsy.goya.cojo.customer.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.domain.BaseJpaEntity;
import com.ysmjjsy.goya.cojo.constant.enums.Gender;
import com.ysmjjsy.goya.cojo.constant.enums.LockStatus;
import com.ysmjjsy.goya.cojo.customer.convertor.enums.GenderConvertor;
import com.ysmjjsy.goya.cojo.customer.convertor.enums.LockStatusConvertor;
import com.ysmjjsy.goya.cojo.role.domain.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 21:32
 */
@Getter
@Setter
@Entity
@Table(name = "t_customer")
@NamedEntityGraph(name = "Customer.lazy", attributeNodes = {@NamedAttributeNode("roles")})
public class Customer extends BaseJpaEntity {
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
            length = 60
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
    @Convert(converter = GenderConvertor.class)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "a_customer_role",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(
            nullable = false,
            length = 1
    )
    @Convert(converter = LockStatusConvertor.class)
    private LockStatus lockStatus;

    public boolean isLock(){
        return LockStatus.LOCK.equals(this.lockStatus);
    }
}
