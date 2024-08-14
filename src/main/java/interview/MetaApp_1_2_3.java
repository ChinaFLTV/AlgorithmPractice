package interview;

import java.util.*;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/13 PM 6:43:07
 * @description MetaApp-笔试1、2、3
 * @filename MetaApp_1_2_3.java
 */

public class MetaApp_1_2_3 {


    public static void main(String[] args) {

        int answer1 = calculateCandyNum(10);
        Integer[] answer2 = findDivisors(72);
        Integer[] answer3 = answer3(new Integer[]{4, 2, 3, 1});


        System.out.println("-----------------------------------------------------------------");
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));

    }


    public static int[] answer(int x) {

        int answer1 = calculateCandyNum(x);
        Integer[] answer2 = findDivisors(answer1);
        Integer[] answer3 = answer3(answer2);

        Integer[] res = new Integer[1 + answer2.length + answer3.length];

        res[0] = answer1;

        System.arraycopy(answer2, 0, res, 1, answer2.length);
        System.arraycopy(answer3, 0, res, 1 + answer2.length, answer3.length);


        int[] res2 = new int[res.length];
        for (int i = 0; i < res.length; i++) {

            res2[i] = res[i].intValue();

        }

        return res2;

    }


    private static int calculateCandyNum(int n) {

        return n + (5 - 1) * 7;

    }


    private static Integer[] findDivisors(int num) {

        int divisor = 1;

        List<Integer> divisors = new ArrayList<>();

        while (divisor <= num) {

            if (num % divisor == 0) {

                divisors.add(divisor);

            }

            divisor++;

        }

        if (divisors.size() <= 4) {

            return divisors.toArray(new Integer[0]);

        } else {

            int size = divisors.size();
            return new Integer[]{divisors.get(size - 1), divisors.get(size - 2), divisors.get(size - 3), divisors
                    .get(size - 4)};

        }

    }


    private static Integer[] answer3(Integer[] nums) {


        Map<Integer, Integer> map = new HashMap<>();


        Integer[] nums2 = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums2, Collections.reverseOrder());

        for (int i = 0; i < nums2.length; i++) {

            map.put(nums2[i], i + 3);

        }

        Integer[] nums3 = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {

            nums3[i] = map.get(nums[i]);

        }

        return nums3;

    }


}
