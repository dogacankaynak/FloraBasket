package com.yaf.florabasket.repository;

import com.yaf.florabasket.model.Flower;
import com.yaf.florabasket.model.Role;
import com.yaf.florabasket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @date 15.05.2020
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("SELECT fbuser u from fbuser where u.email='?");
    User findByEmail(String email);

    //String findByName(String email);
    // @Query("SELECT fbflower u FROM fbflower WHERE u.flower = 'flower' AND u.assigned = 'false'")
    List<User> findAllByFlowers(Flower flower);
    //@Query("SELECT fbrole u FROM fbrole WHERE u.role = 'role' AND u.role = 'true'")
    List<User> findAllByRoles(Role role);

}
