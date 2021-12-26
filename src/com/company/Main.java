package com.company;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        createFiles();
    }

    public static void createFiles(){
        CountDownLatch countDownLatch = new CountDownLatch(2);
        List<FileCreator> fileCreatorList = List.of(
                new FileCreator(countDownLatch),
                new FileCreator(countDownLatch)
        );

        fileCreatorList.forEach(Thread::start);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                fileCreator.run();
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                fileCreator.run();
//            }
//        });
//        ObjectPool<String> pool = new StringPool();
//
//        Thread t1 = new Thread(() -> {
//            String str = pool.get();
//            try {
//                System.out.println("Sleeping 1");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            pool.release(str);
//        });
//
//        Thread t2 = new Thread(() -> {
//            String str = pool.get();
//            try {
//                System.out.println("Sleeping 2");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            pool.release(str);
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


