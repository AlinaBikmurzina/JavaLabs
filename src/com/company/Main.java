package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ReplaceItems()));
        System.out.println(Arrays.toString(FillArray()));
        System.out.println(Arrays.toString(MultiplyByTwo()));
        FillDiagonal();
        //System.out.println(Arrays.toString(FillDiagonal()));
        //System.out.println(Arrays.toString(FindMinMax()));
        FindMinMax();
        System.out.println(CheckBalance());
    }

    public static int[] ReplaceItems() {
        int nums[] = new int[]{1, 1, 0, 0, 0, 0, 1, 1, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                nums[i] = 0;
            }

        }
        return nums;
    }

    public static int[] FillArray() {
        int nums[] = new int[8];
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + 3;
        }
        return nums;
    }

    public static int[] MultiplyByTwo() {
        int nums[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
        return nums;
    }

    public static int[][] FillDiagonal() {
        int[][] nums = new int[5][5];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][i] = 1;
                System.out.printf("%d ", nums[i][j]);
            }
            System.out.println();
        }
        return nums;
    }

    public static void FindMinMax() {
        int nums[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < min) {
                min = nums[j];
            }
        }
        System.out.println("Max= " + max);
        System.out.println("Min= " + min);
    }


    public static boolean CheckBalance() {

        int nums[] = new int[]{2, 2, 2, 1, 2, 2, 10, 2};
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i< nums.length-1; i++) {
            sum1 = sum1 + nums[i];
            for (int j = i + 1; j< nums.length; j++){
                sum2 = sum2 + nums[j];
            }
            if (sum1 == sum2){
                return true;
            }
            sum2 = 0;
        }
        return false;
    }

}