package com.example.luckymoney.respository;

import com.example.luckymoney.domain.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: luckymoney
 * @description: .
 * @author: 张清
 * @create: 2019-12-30 18:54
 **/
public interface LuckmoneyRespository extends JpaRepository<Luckymoney,Integer> {
    public List<Luckymoney> findByMoney(BigDecimal money);

    public List<Luckymoney> findByProducer(String producer);

    public List<Luckymoney> findByProducerAndConsumer(String producer,String consumer);
}
