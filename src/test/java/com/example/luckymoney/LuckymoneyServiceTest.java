package com.example.luckymoney;

import com.example.luckymoney.domain.Luckymoney;
import com.example.luckymoney.service.LuckymoneyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-31 20:01
 **/
// 基于 unit 的测试
@RunWith(SpringRunner.class)
// 将启动整个Spring 的工程
@SpringBootTest
public class LuckymoneyServiceTest {
    @Autowired
    private LuckymoneyService luckymoneyService;

    @Test
    public void findOneTest(){
        Luckymoney luckymoney = luckymoneyService.findOne(1);
        System.out.println(luckymoney);
    }
}
