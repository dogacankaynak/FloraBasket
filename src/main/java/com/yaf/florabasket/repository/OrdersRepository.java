package com.yaf.florabasket.repository;

import com.yaf.florabasket.model.Cart;
import com.yaf.florabasket.model.Orders;
import com.yaf.florabasket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @date 18.05.2020
 */

@Repository("ordersRepository")
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByCartAndPaymentCompletedFalse(Cart cart);
    //@Query("INSERT INTO orders")
    //void save();
    //@Query("SELECT orders o FROM orders WHERE o.seller = 'seller' AND o.assigned = 'false'")

    List<Orders> findAllBySellerAndPaymentCompletedTrue(User seller);

    //@Query("SELECT orders o FROM orders WHERE o.seller = 'seller' AND o.assigned = 'true'")

    List<Orders> findAllByClientAndPaymentCompletedTrue(User client);

    //@Query("SELECT orders order FROM orders WHERE order.courier = 'courier'")
    List<Orders> findAllByCourier(User courier);

}
