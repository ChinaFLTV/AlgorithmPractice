package day128;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/10/14 PM 3:40:37
 * @description 两个线程交替打印1到100的数字
 * @filename AlternatePrintDigit.java
 */

public class AlternatePrintDigit {


    public static void main(String[] args) {

        Runnable runnable1 = new Thread1();
        Thread test1 = new Thread(runnable1);
        test1.setName("test1");
        Thread test2 = new Thread(runnable1);
        test2.setName("test2");
        test1.start();
        test2.start();

    }


    static class Thread1 implements Runnable {


        private volatile int i = 1;


        @Override
        public void run() {

            while (true) {

                synchronized (this) {

                    notify();
                    System.out.println(Thread.currentThread().getName() + " 打印 " + i);
                    i++;

                    if (i < 100) {

                        try {

                            wait();

                        } catch (InterruptedException ignore) {


                        }

                    } else {

                        break;

                    }

                }

            }

        }


    }


    static class Thread2 implements Runnable {


        private final AtomicInteger count = new AtomicInteger(1);
        private final Lock lock = new ReentrantLock();
        private final Condition single = lock.newCondition();
        private final Condition twin = lock.newCondition();


        @Override
        public void run() {

            try {

                lock.lock();

                while (count.get() <= 100) {

                    if (count.get() % 2 == 1) {

                        twin.signal();
                        System.out.println(Thread.currentThread().getName() + " 打印 " + count.get());
                        if (count.incrementAndGet() <= 100) {

                            single.await();

                        }

                    } else {

                        single.notify();
                        System.out.println(Thread.currentThread().getName() + " 打印 " + count.get());
                        if (count.incrementAndGet() <= 100) {

                            twin.await();

                        }

                    }

                }


            } catch (Exception ignore) {


            } finally {

                lock.unlock();

            }

        }


    }


}
