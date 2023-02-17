package com.shop.shop.repository;

import com.shop.shop.constant.ItemSellStatus;
import com.shop.shop.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @PersistenceContext
    EntityManager em;


    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemName("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }

    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemName("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNameTest() {
        this.createItemList();
        List<Item> test = itemRepository.findByItemName("테스트 상품1");
        for (Item item : test) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명 or 상품 상세 설명 테스트")
    public void findByItemNameOrItemDetailTest() {
        this.createItemList();
        List<Item> items = itemRepository.findByItemNameOrItemDetail("테스트 상품1", "테스트 상품 상세 설명6");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 lessthan 테스트")
    public void findByPriceLessThan() {
        this.createItemList();
        List<Item> items = itemRepository.findByPriceLessThan(10005);
        for (Item item : items) {
            System.out.println(item.toString());
            if (itemRepository.existsById(item.getId())) {
                System.out.println("yes");
            }
        }
    }

    @Test
    @DisplayName("query 테스트")
    public void findByItemDetail() {
        this.createItemList();
        List<Item> items = itemRepository.findByItemDetail("테스");
        for (Item item : items) {
            System.out.println(item);
        }
    }

}