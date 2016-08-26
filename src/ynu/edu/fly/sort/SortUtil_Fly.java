package ynu.edu.fly.sort;

import java.util.Comparator;

/**
 * Created by fly on 16-8-22.
 */
public class SortUtil_Fly {
    public Comparator cp;

    public static final int BUBBLESORT = 0; //冒泡排序
    public static final int SELECTSORT = 1; //直接选择排序
    public static final int REVERSESORT = 2; //逆序功能

    //设置排序编码

    public static <T>T[] sort(T[] arr, Comparator<T> cp, int sortcode){
        switch (sortcode){
            case BUBBLESORT: return bubbleSort(arr,cp);
            case SELECTSORT: return selectSort(arr,cp);
            case REVERSESORT: return reverseSort(arr);
        }


        return null;
    }

    private static <T>T[] bubbleSort(T[] arr,Comparator<T> cp){
        for(int i=0; i<arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(cp.compare(arr[j],arr[j+1])>0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    private static <T>T[] selectSort(T[] arr, Comparator<T> cp){
        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(cp.compare(arr[j],arr[i])>0){
                    T temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * 主要实现对数组中的元素反转，即：最后一个与第一个交换.倒数第二个与第二个交换
     * @param arr
     * @param <T>
     * @return
     */

    private static <T>T[] reverseSort(T[] arr){

        for(int i=0,j=arr.length-1; i<j; i++,j--){
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

}


class IntergerCondition<Integer> implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return (java.lang.Integer)o1-(java.lang.Integer)o2;
    }
}

class IntCondition<String> implements Comparator<String>{
    @Override
    public int compare(String o1,String o2){
        return ((java.lang.String)o1).compareTo((java.lang.String)o2);
    }
}

class FloatCondition<Float> implements Comparator<Float>{
    @Override
    public int compare(Float o1, Float o2){
        return (java.lang.Float)o1>(java.lang.Float)o2 ? 1 : -1;
    }
}

class DoubleCondition<Double> implements Comparator<Double>{
    @Override
    public int compare(Double o1, Double o2){
        return (java.lang.Double)o1>(java.lang.Double)o2 ? 1 : -1;
    }
}