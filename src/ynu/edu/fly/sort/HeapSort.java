
public class HeapSort{

    public static void adjustHeap(int[] arr,int low, int up){

        int temp = arr[low];
        for(int i=2*low+1; i<=up; i=i*2+1){
            if(i<up && arr[i]<= arr[i+1]){
                i++;
            }

            if(arr[i] <= temp){
                break;
            }

            arr[low] = arr[i];
            low = i;
        }
        arr[low] = temp;
    }

    public static void HeapSort(int[] arr){
        for(int i=arr.length/2 -1; i>=0; i--){
            adjustHeap(arr,i,arr.length-1);
        }

        for(int i=arr.length-1; i>=0; i++){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            adjustHeap(arr,0,i-1);
        }
    }
}
