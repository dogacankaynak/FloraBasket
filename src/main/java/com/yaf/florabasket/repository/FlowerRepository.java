package com.yaf.florabasket.repository;

import com.yaf.florabasket.model.Flower;
import com.yaf.florabasket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @date 17.05.2020
 */
@Repository("flowerRepository")
public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findBy();

    @Query("SELECT seller from User as s inner join Flower as f on f.flowerName = s.flowers.name")
    List<Flower> findAllBySellers(User seller);

    List<Flower> findAll();

    List<Flower> findAllByColor(String color);

    List<Flower> findAllByCategory(String category);

    List<Flower> findAllByName(String name);

}
