package com.shop.shop.controller;

import com.shop.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class ViewController {
    @GetMapping("/")
    public String mainController() {
        return "main";
    }
}
