package com.company;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class FileCreator extends Thread {
    CountDownLatch countDownLatch;

    public FileCreator(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        while (countDownLatch.getCount() != 0) {
            try {
                File myObj = new File("file" + System.currentTimeMillis() + ".txt");
                if (myObj.createNewFile()) {
                    this.countDownLatch.countDown();
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
