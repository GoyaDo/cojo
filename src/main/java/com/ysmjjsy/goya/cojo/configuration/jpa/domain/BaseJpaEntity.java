package com.ysmjjsy.goya.cojo.configuration.jpa.domain;

import com.ysmjjsy.goya.cojo.configuration.jpa.generator.SnowflakeIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/13 19:44
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseJpaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2771139807736092947L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId",type = SnowflakeIdGenerator.class)
    private Long id;

    @Column(
            nullable = false,
            length = 32
    )
    @CreatedBy
    private @Nullable Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private @Nullable LocalDateTime createdDate;

    @Column(
            nullable = false,
            length = 32
    )
    @LastModifiedBy
    private @Nullable Long lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private @Nullable LocalDateTime lastModifiedDate;
}
