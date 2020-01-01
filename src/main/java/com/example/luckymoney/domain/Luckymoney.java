package com.example.luckymoney.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @program: luckymoney
 * @description:
 * @author: 张清
 * @create: 2019-12-30 18:42
 **/
@Data
@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;


    @Min(value = 1, message = "红包不能太小了")
    @NotNull(message = "金额必传")
    private BigDecimal money;


    private String producer;

    private String consumer;

    public Luckymoney(){

    }

}
