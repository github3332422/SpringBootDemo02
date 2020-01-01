package com.example.luckymoney.service;

import com.example.luckymoney.enums.ResultEnum;
import com.example.luckymoney.exception.MyException;
import com.example.luckymoney.respository.LuckmoneyRespository;
import com.example.luckymoney.domain.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-30 20:16
 **/
@Service
public class LuckymoneyService {

    @Autowired
    private LuckmoneyRespository respository;

    /**
     * 事务指的是数据库的事务，加了注解只是事务提交和回滚，最终是提交到数据库里面的。
     * */
    @Transactional
    public void createTwo(){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setConsumer("zq");
        luckymoney.setMoney(new BigDecimal(520));
        respository.save(luckymoney);

        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setConsumer("zq");
        luckymoney1.setMoney(new BigDecimal(1314));
        respository.save(luckymoney1);
    }

    public void getMoney(Integer id) throws Exception {
        Luckymoney luckymoney = respository.findById(id).orElse(null);
//        Integer money = Integer.parseInt(luckymoney.getMoney().toString());
        Double money = Double.valueOf(luckymoney.getMoney().toString());
        System.out.println(money);
        if(money < 100){
            throw new MyException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if(money >= 100 && money < 1000){
            throw new MyException(101,"这还行吧");
        }
        else{
            throw new MyException(102,"老板太好了");
        }

    }

    /**
     * 查询一个红包信息
     * */
    public Luckymoney findOne(Integer id)
    {
        return respository.findById(id).orElse(null);
    }
}
