package com.sunoplya.maksim;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Test {

    private static final Logger log = LogManager.getLogger();
    private static final List<Integer> randoms = new ArrayList<>();
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    private static final Thread writer = new Thread(() -> {
        while (true) {
            try {
                SEMAPHORE.acquire();
                synchronized (randoms) {
                    log.info("-----Writer working-----");
                    int countNumbers = getRandomInt(10);
                    for (int i = 0; i < countNumbers; i++) {
                        randoms.add(getRandomInt(10000));
                    }
                    log.info("Number size: " + randoms.size());
                    log.info("-----Writer end-----\n");
                }
                Thread.sleep(2000);
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });

    private static final Thread reader = new Thread(() -> {
        while (true) {
            try {
                SEMAPHORE.acquire();
                synchronized (randoms) {
                    log.info("-----Reader working-----");
                    log.info("Numbers: " + randoms);
                    List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(randoms);
                    copyOnWriteArrayList.forEach((number) -> {
                        log.info("Deleting number " + number);
                        randoms.remove(number);
                    });
                    log.info("-----Reader end-----\n");
                }
                Thread.sleep(2000);
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });

    public static void main(String[] args) {
        reader.setDaemon(true);
        writer.setDaemon(true);
        writer.start();
        reader.start();
        while (true) {

        }
    }

    private static int getRandomInt(int max) {
        Random randomInt = new Random();
        return randomInt.nextInt(max);
    }
}