package ynu.edu.fly.sort;
import java.util.Arrays;

/**
 * Created by fly on 16-8-21.
 */
public class GenericSort_Test {


    public static void main(String[] args){
//        Integer []arr = {1,3,2,4,9,5,7,6,8,0};
        Float []arr = {-3.5f,0.1f,1.0f,9.0f,0.0f, -2.5f};
        System.out.println(Arrays.toString(arr));
//        arr = SortUtil_Fly.sort(arr,new IntergerCondition(), SortUtil_Fly.BUBBLESORT);
        arr = SortUtil_Fly.sort(arr, new FloatCondition(), SortUtil_Fly.SELECTSORT);
        System.out.println(Arrays.toString(arr));
    }


}


