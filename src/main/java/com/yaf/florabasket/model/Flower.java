package com.yaf.florabasket.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @date 17.05.2020
 */

@Entity
@Table(name="flower")
@ToString
@Query("create table flower (id int8 not null, category varchar(255), color varchar(255), explanation varchar(100000), hover_image_link varchar(255), imagelink varchar(255), imagelink2 varchar(255), imagelink3 varchar(255), imagelink4 varchar(255), name varchar(255), price varchar(255), primary key (id))")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Getter
    @Setter
    private Long id;

    @NonNull
    @Column(name="name")
    @Getter
    @Setter
    private String name;

    @NonNull
    @Column(name="price")
    @Getter
    @Setter
    private String price;

    @NonNull
    @Column(name="imagelink")
    @Getter
    @Setter
    private String imagelink;

    @NonNull
    @Column(name="hoverImageLink")
    @Getter
    @Setter
    private String hoverImageLink;

    @NonNull
    @Column(name="imagelink2")
    @Getter
    @Setter
    private String imagelink2;

    @NonNull
    @Column(name="imagelink3")
    @Getter
    @Setter
    private String imagelink3;

    @NonNull
    @Column(name="imagelink4")
    @Getter
    @Setter
    private String imagelink4;

    @NonNull
    @Column(name="explanation", length = 100000 )
    @Getter
    @Setter
    private String explanation;

    @Column(name="color")
    @Getter
    @Setter
    private String color;

    @Column(name="category")
    @Getter
    @Setter
    private String category;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "flower_seller", joinColumns = @JoinColumn(name = "flower_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
    @Getter
    @Setter
    private Set<User> sellers;

}
