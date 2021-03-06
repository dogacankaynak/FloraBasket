package com.yaf.florabasket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @date 17.05.2020
 */

@Entity
@Table(name = "cart")
@Query("create table cart (id int8 not null, total int4, client_id int4, primary key (id))")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Getter
    @Setter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User client;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Orders> orders;

    @Getter
    @Setter
    private Integer total;

}
