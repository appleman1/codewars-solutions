package com.falkenberg.viktor.codewars.kata3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(snail(new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        })));
        System.out.println(
            Arrays.toString(
                snail(
                    new int[][] {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                    }
                )
            )
        );

    }

    public static int[] snail(int[][] array) {
        if (array == null || Arrays.deepEquals(array, new int[][] {})) {
            return new int[] {};
        }
        int[] result = new int[] {};
        while (array.length != 1 && array.length != 0) {
            result = getOuterCircle(array, result);
            array = cutCircle(array);
        }
        if (array.length != 0) {
            return addElement(result, array[0][0]);
        } else {
            return result;
        }
    }

    public static int[] getOuterCircle(int[][] array, int[] result) {
        if (array.length == 1) {
            return new int[] {array[0][0]};
        }
        int lengthVertical = array.length;
        int lengthHorizontal = array[0].length;

        for (int i = 0; i < lengthHorizontal; i++) {
            result = addElement(result, array[0][i]);
        }
        for (int i = 1; i < lengthVertical; i++) {
            result = addElement(result, array[i][lengthHorizontal - 1]);
        }
        for (int i = lengthHorizontal - 2; i >= 0; i--) {
            result = addElement(result, array[lengthVertical - 1][i]);
        }
        for (int i = lengthVertical - 2; i > 0; i--) {
            result = addElement(result, array[i][0]);
        }
        return result;
    }

    public static int[][] cutCircle(int[][] array) {
        int lengthVertical = array.length;
        int lengthHorizontal = array[0].length;
        if (lengthVertical == 3 && lengthHorizontal == 3) {
            return new int[][] {{array[1][1]}};
        }
        int[][] result = new int[lengthVertical - 2][lengthHorizontal - 2];
        for (int i = 0; i < lengthVertical; i++) {
            for (int j = 0; j < lengthHorizontal; j++) {
                if (i != 0 && j != 0 && i != lengthVertical - 1 && j != lengthHorizontal - 1) {
                    result[i - 1][j - 1] = array[i][j];
                }
            }
        }
        return result;
    }

    public static int[] addElement(int[] ints, int number) {
        int[] result = Arrays.copyOf(ints, ints.length + 1);
        result[result.length - 1] = number;
        return result;
    }

//not my
    public static int[] snail2(int[][] a) {
        int n = a[0].length, ret[] = new int[n * n], o = 0, j = 0;
        while (n > 0) {
            for (int x = o, y = o; x < o + n; x++) {
                ret[j++] = a[y][x];
            }
            for (int x = o + n - 1, y = o + 1; y < o + n; y++) {
                ret[j++] = a[y][x];
            }
            for (int x = o + n - 2, y = o + n - 1; x >= o; x--) {
                ret[j++] = a[y][x];
            }
            for (int x = o, y = o + n - 2; y > o; y--) {
                ret[j++] = a[y][x];
            }
            o++;
            n -= 2;
        }
        return ret;
    }
}
