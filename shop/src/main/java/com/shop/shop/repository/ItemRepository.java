package com.shop.shop.repository;

import com.shop.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemNm);

    List<Item> findByItemNameOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(int price);

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String detail);

}
