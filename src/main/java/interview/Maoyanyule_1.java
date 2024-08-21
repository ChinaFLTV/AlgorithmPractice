package interview;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/20 PM 8:14:54
 * @description 猫眼娱乐-面试-1-两个线程分别打印奇数和偶数
 * @filename Maoyanyule_1.java
 */

public class Maoyanyule_1 {


    public static void main(String[] args) {

        ShowMeBug showMeBug = new ShowMeBug(100);
        Thread t1 = new Thread(() -> {
            try {
                showMeBug.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {

            showMeBug.printOdd();

        });
        t1.start();
        t2.start();

    }


}


class ShowMeBug {


    private volatile int num = 1;
    /**
     * 最大数字
     */
    private final int maxCount;


    public ShowMeBug(int maxCount) {

        this.maxCount = maxCount;

    }


    /**
     * todo: 请实现该方法，让其从 1 开始打印奇数
     */
    public void printOdd() {

        while (true) {

            synchronized (ShowMeBug.class) {

                if (num % 2 == 0) {

                    continue;

                }

                System.out.println("OddThread: " + num);

                if (num >= maxCount) {

                    return;

                }

                num++;

            }

        }

    }


    /**
     * todo: 请实现该方法，让其从 2 开始打印偶数
     */
    public void printEven() throws InterruptedException {

        while (true) {

            synchronized (ShowMeBug.class) {

                if (num % 2 == 1) {

                    continue;

                }

                System.out.println("EvenThread: " + num);

                if (num >= maxCount) {

                    return;

                }

                num++;

            }

        }

    }


}