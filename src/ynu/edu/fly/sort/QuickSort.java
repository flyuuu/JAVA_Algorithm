
public class QuickSort{

    public static int partition(int[] arr, int low, int up){

        int povit = arr[low];
        while(low < up){
            while(low<up && arr[up] > povit) up--;
            arr[low] = arr[up];

            while(low<up && arr[low] < povit) low++;
            arr[up] = arr[low];
        }
        arr[low] = povit;
        return low;
    }

    public static void QSort(int[] arr,int low, int up){
        if(low<up){
            int pi = partition(arr,low,up);
            QSort(arr,low,pi-1);
            QSort(arr,pi+1,up);
        }
    }
}
