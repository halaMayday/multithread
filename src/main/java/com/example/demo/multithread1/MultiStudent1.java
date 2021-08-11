package com.example.demo.multithread1;

import com.example.demo.common.Punishment;

/**
 * 继承Thread类，重写run方法..
 *
 * @author ：hf
 * @date ：Created in 2021/8/10 12:35
 */
public class MultiStudent1 extends Thread {

    /**
     * 学生姓名 .
     */
    private String name;
    /**
     * 惩罚   .
     */
    private Punishment punishment;

    public MultiStudent1(String name, Punishment punishment) {
        super(name);
        this.name = name;
        this.punishment = punishment;
    }

    private void copyWorld() {
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true) {
            if (punishment.getLeftCopyCount() > 0) {
                int leftCopyCount = punishment.getLeftCopyCount();
                System.out.println(threadName + "线程-" + name + "抄写" + punishment.getWordToCopy() + ".还要抄写" +
                        --leftCopyCount + "次");
                punishment.setLeftCopyCount(leftCopyCount);
                count++;
            } else {
                break;
            }
        }
        System.out.println(threadName + "线程-" + "一共抄写了" + count);
    }

    @Override
    public void run() {
        copyWorld();
    }
}
