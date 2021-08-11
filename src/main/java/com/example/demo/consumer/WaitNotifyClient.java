package com.example.demo.consumer;

import com.example.demo.common.Punishment;
import java.util.LinkedList;

/**
 * @author ：hf
 * @date ：Created in 2021/8/12 12:23 上午
 */
public class WaitNotifyClient {

    public static void main(String[] args) {
        LinkedList<Punishment> tasks = new LinkedList<>();
        ConsumerStudent xiaoming = new ConsumerStudent("小明", tasks);
        xiaoming.start();
        ConsumerStudent xiaowang = new ConsumerStudent("小王", tasks);
        xiaowang.start();
        ProducerTecher lilaoshi = new ProducerTecher("李老师", tasks);
        lilaoshi.start();
        ProducerTecher zhanglaoshi = new ProducerTecher("张老师", tasks);
        zhanglaoshi.start();
    }
}
