package com.example.demo.threadapi;

import com.example.demo.common.Punishment;
import com.example.demo.multithread1.MultiStudent1;

/**
 * .
 *
 * @author ：hf
 * @date ：Created in 2021/8/11 15:47
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Punishment punishment1 = Punishment.builder().wordToCopy("KUBERNETES")
                .leftCopyCount(10).build();
        Punishment punishment2 = Punishment.builder().wordToCopy("KUBEVIRT")
                .leftCopyCount(10).build();
        Punishment punishment3 = Punishment.builder().wordToCopy("CHECK")
                .leftCopyCount(10).build();
        MultiStudent1 tom = new MultiStudent1("tom", punishment1);
        MultiStudent1 jack = new MultiStudent1("jack", punishment2);
        MultiStudent1 hufan = new MultiStudent1("hufan", punishment3);
        tom.start();
        jack.start();
        tom.join();
        jack.join();
        hufan.start();
    }
}
