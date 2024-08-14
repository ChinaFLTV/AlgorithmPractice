package interview;

import java.util.Scanner;

/**
 * @author Lenovo/LiGuanda
 * @version 1.0.0
 * @date 2024/8/14 PM 7:43:09
 * @description 用友-笔试2-小明负责维护公司内部的电力供应网络，公司由n*n的网格组成，每个单元格代表一个区域。有电力设施的区域用1表示，没有则用0表示
 * @filename Yongyou_2.java
 */

public class Yongyou_2 {


    private static int edgeLength;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            edgeLength = scanner.nextInt();
            int j = 0;

            int[][] grid = new int[edgeLength][edgeLength];

            while (scanner.hasNextLine()) {


                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {

                    continue;

                }

                String[] numStrs = input.split(" ");

                int[] nums = new int[numStrs.length];

                for (int i = 0; i < numStrs.length; i++) {

                    nums[i] = Integer.parseInt(numStrs[i]);

                }

                grid[j] = nums;

                j++;

                if (j == edgeLength) {

                    break;

                }

            }

            int maxDistance = 0;

            for (int n = 0; n < edgeLength; n++) {

                for (int m = 0; m < edgeLength; m++) {

                    if (grid[n][m] == 0) {

                        int distance = findElectricity(grid, n, m, 0);
                        if (distance != Integer.MAX_VALUE) {

                            maxDistance = Math.max(maxDistance, distance);

                        }

                    }

                }

            }

            System.out.println(maxDistance == 0 ? -1 : maxDistance);

        }

    }


    private static int findElectricity(int[][] grid, int n, int m, int i) {

        if (n < 0 || n >= edgeLength || m < 0 || m >= edgeLength) {

            return Integer.MAX_VALUE;

        }

        if (grid[n][m] == 1) {

            return i;

        }

        if (grid[n][m] == 2) {

            return Integer.MAX_VALUE;

        }

        grid[n][m] = 2;

        int up = findElectricity(grid, n - 1, m, i + 1);
        int right = findElectricity(grid, n, m + 1, i + 1);
        int down = findElectricity(grid, n + 1, m, i + 1);
        int left = findElectricity(grid, n, m - 1, i + 1);

        grid[n][m] = 0;

        int maxDistance = Integer.MAX_VALUE;
        maxDistance = Math.min(maxDistance, up);
        maxDistance = Math.min(maxDistance, right);
        maxDistance = Math.min(maxDistance, down);
        maxDistance = Math.min(maxDistance, left);

        return maxDistance;

    }


}