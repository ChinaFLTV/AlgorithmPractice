package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author LiGuanda
 * @version 1.0.0
 * @date 2024/8/8 12:08
 * @description 搜狐畅游-笔试1-要求用户读入一串数字并返回这串数字的平均值
 * @filename SohuChangyou_1.kt
 */

public class SohuChangyou_1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {

            String input = scanner.nextLine();
            List<Integer> nums = Arrays.stream(input.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

            double sum = 0.0;

            for (Integer num : nums) {

                sum += num;

            }

            System.out.printf("%.1f\n", sum / nums.size());

        }

    }


}