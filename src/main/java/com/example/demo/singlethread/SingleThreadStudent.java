package com.example.demo.singlethread;

import com.example.demo.common.Punishment;

/**
 * .
 *
 * @author ：hf
 * @date ：Created in 2021/8/10 11:05
 */
public class SingleThreadStudent {
    /**
     * 学生姓名 .
     */
    private String name;
    /**
     * 惩罚   .
     */
    private Punishment punishment;

    public SingleThreadStudent(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWorld() {
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
}
