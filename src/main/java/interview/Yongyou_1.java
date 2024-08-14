package interview;

import java.util.Scanner;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/14 PM 7:11:57
 * @description 用友-笔试1-小明正在优化财务报表分析功能。给定一个不同整数构成的数组revenues，每个元素表示在不同时间段内的收入
 * @filename Yongyou_1.java
 */

public class Yongyou_1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            int length = scanner.nextInt();

            while (scanner.hasNextLine()) {

                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {

                    continue;

                }

                Integer[] revenues = new Integer[length];

                String[] numStrs = input.split(" ");
                for (int i = 0; i < numStrs.length; i++) {

                    revenues[i] = Integer.parseInt(numStrs[i]);

                }

                Integer[] maxDurations = new Integer[length];

                for (int i = 0; i < revenues.length; i++) {

                    int maxDuration = findLongestSubArrayLength(revenues, i, length);
                    maxDurations[i] = maxDuration;
                    System.out.print(maxDurations[i] + "");
                    if (i <= length - 2) {

                        System.out.print(" ");

                    }

                }

                System.out.println();

            }


        }

    }


    private static int findLongestSubArrayLength(Integer[] revenues, int i, int length) {

        int res = 1;
        int num = revenues[i];

        int p = i - 1;
        while (p >= 0) {

            if (revenues[p] <= num) {

                res++;
                p--;

            } else {

                break;

            }

        }

        p = i + 1;

        while (p < length) {

            if (revenues[p] <= num) {

                res++;
                p++;

            } else {

                break;

            }

        }

        return res;

    }


}
