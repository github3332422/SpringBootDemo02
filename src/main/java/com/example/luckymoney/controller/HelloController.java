package com.example.luckymoney.controller;

import com.example.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-30 10:17
 **/
//@RestController
@Controller
//@ResponseBody
//@RestController
public class HelloController {
//    @Value("${minMoney}")
//    private BigDecimal minMoney;
//    @Value("${maxMoney}")
//    private BigDecimal maxMoney;
//    @Value("${deacription}")
//    private String deacription;
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping({"/hello","/hi"})
    @ResponseBody
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "minMoney:" + limitConfig.getMinMoney()+ "maxMoney:" + limitConfig.getMaxMoney()  + "说明: " + limitConfig.getDescription();
//        return "index";
    }

    @GetMapping("/hello2")
    public String say2(){
        return "index";
    }

    @GetMapping("/hello/say/{id}")
    @ResponseBody
    public String say3(@PathVariable("id") Integer id){
        return "id : " + id;
    }

    @GetMapping("/hello/said")
    @ResponseBody
    public String say4(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id : " + id;
    }
}
