package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interview4399 {


    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int a, b;
        while (cin.hasNextInt()) {

            // 逐行读取输入
            list.add(cin.nextInt());

        }

        if (list.isEmpty())
            System.out.println(0);

        if (list.size() == 1)
            System.out.println(list.get(0));


        Integer[] dp = new Integer[list.size() + 1];
        dp[0] = 0;
        dp[1] = list.get(0);
        dp[2] = Math.max(list.get(0), list.get(1));


        for (int i = 3; i < dp.length; i++) {

            dp[i] = Math.max(dp[i - 1], list.get(i - 1) + dp[i - 2]);

        }

        System.out.println(dp[list.size()]);

    }


}