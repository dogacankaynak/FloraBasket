package com.yaf.florabasket.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @date 10.05.2020
 */


@Entity
@Table(name="fbuser")
@Query("create table cart (id int8 not null, total int4, client_id int4, primary key (id))")
public class User {

    @Id
    @TableGenerator(name = "fbuser_id_gen", initialValue = 15)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "fbuser_id_gen")
    @Column(name="id")
    @Getter
    @Setter
    private int id;

    @NonNull
    @Column(name="email")
    @Getter
    @Setter
    private String email;

    @NonNull
    @Column(name="firstname")
    @Getter
    @Setter
    private String firstname;

    @NonNull
    @Column(name="surname")
    @Getter
    @Setter
    private String surname;

    @NonNull
    @Column(name="password")
    @Getter
    @Setter
    private String password;

    @Column(name="enabled")
    @Getter
    @Setter
    private int enabled;

    @Column(name="phone")
    @Getter
    @Setter
    private String phoneNumber;

    @Column(name="website")
    @Getter
    @Setter
    private String website;

    @Column(name="city")
    @Getter
    @Setter
    private String city;

    @Column(name="town")
    @Getter
    @Setter
    private String town;

    @Column(name="address")
    @Getter
    @Setter
    private String address;

    @Column(name="seller")
    @Getter
    @Setter
    private boolean seller;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "fbuser_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter
    @Setter
    private Set<Role> roles;

    @OneToOne(mappedBy = "client")
    @Getter
    @Setter
    private Cart cart;

    @ManyToMany(mappedBy = "sellers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Getter
    @Setter
    private Set<Flower> flowers;

}
