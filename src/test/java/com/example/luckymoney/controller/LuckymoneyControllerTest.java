package com.example.luckymoney.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LuckymoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/luckymoneys"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("abc")); //判断返回内容是否是 abc
    }

    @Test
    void getMoney() {
    }

    @Test
    void luckymoneyListBySendUser() {
    }

    @Test
    void createLuckymoney() {
    }

    @Test
    void luckymoneyAdd() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteLuckymoneyById() {
    }

    @Test
    void createTwo() {
    }
}