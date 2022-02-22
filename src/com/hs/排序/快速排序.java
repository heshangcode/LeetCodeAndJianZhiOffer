package com.hs.排序;

import java.util.Arrays;

/**
 * 随机选一个数.
 *
 * @Author heshang.ink
 * @Date 2019/8/21 18:42
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 1, 2, 8, 7, 5, 6};
        System.out.println("快速排序前：" + Arrays.toString(arr));
        quickSort1(arr, 0, arr.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //轴点
            int p = arr[start];
            //两个指针进行移动
            int low = start;
            int high = end;
            while (low < high) {
                //处理右边比他大的数，一直比他大，high--
                while (low < high && arr[high] >= p) {
                    high--;
                }
                //找到一个比他小的数，放到右边去
                arr[low] = arr[high];
                //处理左边比他小的数，一直比他小，low++
                while (low < high && arr[low] < p) {
                    low++;
                }
                //找到一个比他小的数，放到左边去
                arr[high] = arr[low];
            }
            arr[low] = p;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);

        }
    }

    public static void quickSort1(int[] array, int start, int end) {

        if (start < end) {
            int p = array[start];
            int low = start, high = end;
            while (low < high) {

                while (low < high && array[high] > p) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= p) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = p;
            quickSort(array, start, low);
            quickSort(array, low + 1, end);
        }

    }

    public static int erfen(int[] arr, int target, int start, int end) {
        int middle = (start + end) >> 1;
        if (arr[middle] > target) {
            return erfen(arr, target, start, middle - 1);
        } else if (arr[middle] < target) {
            return erfen(arr, target, middle + 1, end);
        } else {
            return middle;
        }
    }
}
