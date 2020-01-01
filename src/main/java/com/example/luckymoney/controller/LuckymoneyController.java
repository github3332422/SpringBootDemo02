package com.example.luckymoney.controller;

import com.example.luckymoney.domain.Result;
import com.example.luckymoney.respository.LuckmoneyRespository;
import com.example.luckymoney.domain.Luckymoney;
import com.example.luckymoney.service.LuckymoneyService;
import com.example.luckymoney.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-30 18:52
 **/
@RestController
public class LuckymoneyController {

    @Autowired
    private LuckmoneyRespository respository;
    @Autowired
    private LuckymoneyService luckymoneyService;
    /**
     * 获取红包列表
     * */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return respository.findAll();
    }

    /**
     * 通过发送的钱数查询
     * */
//    @GetMapping(value = "/luckymoneys/getMoney/{money}")
//    public Result luckymoneyListByMoney(@PathVariable("money") BigDecimal money){
//        return ResultUtils.success(respository.findByMoney(money));
//    }
    @GetMapping(value = "/luckymoneys/getMoney/{id}")
    public void getMoney(@PathVariable("id") Integer id) throws Exception {
        luckymoneyService.getMoney(id);
    }

    /**
     * 根据红包发送人进行查询
     * */
    @GetMapping(value = "/luckymoneys/getUser/{producer}")
    public Result luckymoneyListBySendUser(@PathVariable("producer") String producer){
        return ResultUtils.success(respository.findByProducer(producer));
    }

    /**
     * 创建红包
     * */
    @PostMapping("/luckymoneys")
    public Result createLuckymoney(@RequestParam("producer") String producer,
                                       @RequestParam("consumer") String consumer,
                                       @RequestParam("money") BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setConsumer(consumer);
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return ResultUtils.success(respository.save(luckymoney));
    }
    @PostMapping(value = "/luckymoneys1")
    public Result luckymoneyAdd(@Valid Luckymoney luckymoney, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        luckymoney.setConsumer(luckymoney.getConsumer());
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());
        return ResultUtils.success(respository.save(luckymoney));
    }

    /**
     * 查询红包
     * */
    @GetMapping("/luckymoneys/{id}")
    public Result findById(@PathVariable("id") Integer id){
        return ResultUtils.success(respository.findById(id).orElse(null));
    }

    /**
     * 更新红包
     * */
    @PutMapping("/luckymoneys/{id}")
    public Result updateById(@PathVariable("id") Integer id,
                                @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = respository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return ResultUtils.success(respository.save(luckymoney));
        }
        return ResultUtils.error(0,"要更新的红包不存在");
    }

    /**
     * 删除红包
     * */
    @DeleteMapping("/luckymoneys/{id}")
    public Result deleteLuckymoneyById(@PathVariable("id") Integer id){
        respository.deleteById(id);
        return ResultUtils.success();
    }

    /**
     * 测试事务
     * */
    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }
}
