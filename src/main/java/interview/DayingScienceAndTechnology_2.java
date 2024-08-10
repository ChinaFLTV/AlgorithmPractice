package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/2 PM 7:27:32
 * @description 大应科技测评-2-请用Java实现顺序交替打印1~100，输出内容包括线程名称和数字
 * @filename DayingScienceAndTechnology_2.java
 */

public class DayingScienceAndTechnology_2 {


    /*public static void main(String[] args) {

        final ReentrantLock lock = new ReentrantLock();
        AtomicInteger count = new AtomicInteger(0);

        Condition itsMyTurn = lock.newCondition();

        Runnable runnable = () -> {

            while (true) {

                try {

                    lock.lock();

                    if (count.get() == 100) {

                        lock.unlock();
                        return;

                    }

                    count.getAndIncrement();
                    System.out.printf("Thread : %s ===> count = %d\n", Thread.currentThread().getName(), count.get());

                    lock.unlock();

                } catch (Exception ignore) {


                }

            }

        };

        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");

        thread1.start();
        thread2.start();

    }*/


    private static final Integer N = 6;
    private static volatile Integer count = 0;
    private static final Object LOCK = new Object();


    public static void main(String[] args) {

        System.out.println("开始测试...");
        for (int i = 0; i < N; i++) {

            // new Worker(i).start();
            // new WorkerPro(i).start();
            new WorkerProMax(i).start();

        }

    }


    static class Worker extends Thread {


        private final Integer id;


        public Worker(Integer id) {

            this.id = id;

        }


        @Override
        public void run() {

            while (true) {

                if (count % N == id) {

                    synchronized (LOCK) {

                        count++;

                        if (count > 100) {

                            return;

                        }

                        System.out.printf("线程名称 : %s ====> count : %d\n", "thread-" + id, count);

                    }

                }

            }

        }


    }


    static class WorkerPro extends Thread {


        private final Integer id;


        public WorkerPro(Integer id) {

            this.id = id;

        }


        @Override
        public void run() {

            while (true) {

                synchronized (LOCK) {

                    if (count % N == id) {

                        count++;

                        if (count > 100) {

                            LOCK.notifyAll();
                            return;

                        }

                        System.out.printf("线程名称 : %s ====> count : %d\n", "thread-pro-" + id, count);

                        LOCK.notifyAll();

                        try {

                            LOCK.wait();

                        } catch (Exception ignore) {


                        }

                    }

                }

            }

        }


    }


    static final ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    static class WorkerProMax extends Thread {

        private final Integer id;


        public WorkerProMax(Integer id) {

            this.id = id;

        }


        @Override
        public void run() {

            while (true) {

                lock.lock();

                if (count % N == id) {

                    count++;

                    if (count > 100) {

                        condition.signal();
                        lock.unlock();
                        return;

                    }

                    System.out.printf("线程名称 : %s ====> count : %d\n", "thread-pro-max-" + id, count);

                    condition.signal();

                    try {

                        condition.await();

                    } catch (Exception ignore) {


                    }

                }

                lock.unlock();

            }

        }


    }


}