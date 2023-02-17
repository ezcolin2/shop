package com.shop.shop.dto;

import com.shop.shop.constant.ItemSellStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ItemDto {
    private Long id;
    private String itemName;
    private int price;
    private int stockNumber;
    private String itemDetail;
    private String sellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
