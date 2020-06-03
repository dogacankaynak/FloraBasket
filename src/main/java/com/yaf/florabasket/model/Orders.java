package com.yaf.florabasket.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

/**
 *
 * @date 11.05.2020
 */

@Entity
/**
@Query("CREATE TABLE ORDERS(
            id INT IDENTITY PRIMARY KEY,
            quantity INT NOT NULL,
            flower_id User NOT NULL,
            cart_id INT NOT NULL,
            courier_id User NOT NULL,
            client_id User NOT NULL,
            seller_id User NOT NULL,
            status VARCHAR(255),
            address VARCHAR(255),
            note VARCHAR(255),
            occasion VARCHAR(255),
            deliveryType VARCHAR(255),
            paymentMethod VARCHAR(255),
            paymentCompleted Boolean,
            deliveryStatus VARCHAR(255)")
 */
@Table(name = "orders")
        @Query("create table orders (id int8 not null, address varchar(255), delivery_status varchar(255), delivery_type varchar(255), note varchar(255), occasion varchar(255), payment_completed boolean, payment_method varchar(255), quantity int4, status varchar(255), cart_id int8, client_id int4, courier_id int4, flower_id int8, seller_id int4, primary key (id))")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Getter
    @Setter
    private Long id;

    @NonNull
    @Column(name="quantity")
    @Getter
    @Setter
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Flower flower;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Cart cart;

    @ManyToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User courier;

    @ManyToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User client;

    @ManyToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User seller;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Column(name = "note")
    @Getter
    @Setter
    private String note;

    @Column(name = "occasion")
    @Getter
    @Setter
    private String occasion;

    @Column(name = "deliveryType")
    @Getter
    @Setter
    private String deliveryType;

    @Column(name = "paymentMethod")
    @Getter
    @Setter
    private String paymentMethod;

    @Column(name = "paymentCompleted")
    @Getter
    @Setter
    private Boolean paymentCompleted;

    @Column(name = "deliveryStatus")
    @Getter
    @Setter
    private String deliveryStatus;

}
