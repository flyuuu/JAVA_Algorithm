
public class MergeSort{

    public static void merge(int[] arr,int[] temp,int low, int mid, int up){
        int l = low;
        int i,j;
        for(i=0, j=mid+1; low<=mid && j<=up; i++){
            if(arr[low] < arr[j]){
                temp[i] = arr[low++];
            }else{
                temp[i] = arr[j++];
            }
        }

        while(low<=mid){
            temp[i++] = arr[low++];
        }

        while(j<=up){
            temp[i++] = arr[j++];
        }

        for(i=0; i<up-l+1; i++){
            arr[l+i] = temp[i];
        }
    }

    public static void MSort(int[] arr,int[] temp,int low,int up){
        if(up-low < 1){
            return;
        }else{
            int mid = (low+up)/2;
            MSort(arr,temp,low,mid);
            MSort(arr,temp,mid+1,up);

            merge(arr,temp,low,up);
        }
    }
}
