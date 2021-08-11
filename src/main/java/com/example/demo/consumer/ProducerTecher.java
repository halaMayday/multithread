package com.example.demo.consumer;

import com.example.demo.common.Punishment;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * @author ：hf
 * @date ：Created in 2021/8/11 11:50 下午
 */
public class ProducerTecher extends Thread{
    /**
     * 老师姓名 .
     */
    private String name ;

    private LinkedList<Punishment> tasks;

    private List<String> punishWords = Arrays.asList("Kubernetes","kubevirt","cr7");

    private int MAX = 10;

    public ProducerTecher(String name,LinkedList<Punishment> tasks){
        super(name);
        this.name = name;
        this.tasks = tasks;
    }

    private String getPunishedWord(){
        return punishWords.get(new Random().nextInt(punishWords.size()));
    }
    public void dispathPunishment(){
        String threadName = Thread.currentThread().getName();
        while (true){
            synchronized (tasks){
                if (tasks.size() < MAX){
                    Punishment task = Punishment.builder()
                            .leftCopyCount(new Random().nextInt(3) + 1)
                            .wordToCopy(getPunishedWord()).build();
                    tasks.add(task);
                    System.out.println(threadName + "留了作业，抄写" +
                            task.getWordToCopy() + " " + task.getLeftCopyCount() + "次");
                    tasks.notifyAll();
                }else {
                    System.out.println(threadName+"开始等待");
//                    tasks.wait();
                    System.out.println("teacher 线程 " + threadName + "线程-" + name + "等待结束");
                }
            }
        }
    }

    @Override
    public void run() {
        dispathPunishment();
    }
}
