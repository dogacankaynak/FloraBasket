package com.yaf.florabasket.model;

import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

/**
 *
 * @date 15.05.2020
 */

@Data
@Entity
@Table(name = "role")
        @Query("create table role (id int8 not null, role varchar(255), primary key (id))")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;

}
