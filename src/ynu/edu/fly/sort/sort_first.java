package ynu.edu.fly.sort;

import java.util.Arrays;

/**
 * Created by fly on 16-8-19.
 */
public class sort_first {

    public int[] sort(int[] arr){

        for(int i=arr.length-1; i>0; i--){ //每次选取一个值
            for(int j=0; j<i; j++) { //每次与前面的0-i比较
                if(arr[i]< arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }


    public float[] sort(float[] arr){

        for(int i=arr.length-1; i>0; i--){ //每次选取一个值
            for(int j=0; j<i; j++) { //每次与前面的0-i比较
                if(arr[i]< arr[j]){
                    float temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args){
//        int []arr = {1,9,5,4,7,3,8,2,6,10};
        float []arr = {-3.5f,0.1f,1.0f,9.0f,0.0f};

        System.out.println(Arrays.toString(arr));

        float[] res = new sort_first().sort(arr);

        System.out.println(Arrays.toString(res));
    }
}
