package com.poly.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("api/public/hien-thi")
    public String publicAPI() {
        return "Duong dan danh cho tat ca deu truy cap";
    }

    @GetMapping("api/admin/hien-thi")
    public String adminAPI() {
        return "Duong dan danh cho admin";
    }

    @GetMapping("api/user/hien-thi")
    public String userAPI() {
        return "Duong dan danh cho user";
    }

}
