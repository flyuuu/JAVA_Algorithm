package ynu.edu.fly.sort;

import java.util.Arrays;

/**
 * Created by fly on 16-8-19.
 */
public class ReverseSort {

    /**
     * 主要实现对数组中的元素反转，即：最后一个与第一个交换
     *                           倒数第二个与第二个交换
     *
     * @param arr
     *          需要逆序的数组
     */

    public int[] sort(int[] arr){

        for(int i=0,j=arr.length-1; i<j; i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    public static void main(String[] args){
        int []arr = {1,9,5,4,7,3,8,2,6};

        System.out.println(Arrays.toString(arr));

        int[] res = new ReverseSort().sort(arr);

        System.out.println(Arrays.toString(res));
    }
}
