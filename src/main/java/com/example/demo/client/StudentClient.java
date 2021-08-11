package com.example.demo.client;

import com.example.demo.common.Punishment;
import com.example.demo.multithread1.MultiStudent1;
import com.example.demo.multithread2.MultiStudent2;
import com.example.demo.singlethread.SingleThreadStudent;

/**
 * .
 *
 * @author ：hf
 * @date ：Created in 2021/8/10 11:24
 */
public class StudentClient {
    public static void main(String[] args) {
        Punishment punishment = Punishment.builder().wordToCopy("KUBERNETES")
                .leftCopyCount(1000).build();

        //MultiThread1Test(punishment);
        MultiThread2Test(punishment);
    }

    private static void singleThreadTest(Punishment punishment){
        SingleThreadStudent singleThreadStudent = new SingleThreadStudent("hf", punishment);
        singleThreadStudent.copyWorld();
    }

    private static void MultiThread1Test(Punishment punishment){
        MultiStudent1 student = new MultiStudent1("hufan", punishment);
        student.start();
    }

    private static void MultiThread2Test(Punishment punishment){
        MultiStudent2 student = new MultiStudent2("hufan", punishment);
        Thread thread = new Thread(student);
        thread.start();
    }


}
