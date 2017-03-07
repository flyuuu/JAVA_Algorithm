
public class SSort{

    public static void BubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void SelectSort(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void InsertSort(int[] arr){

        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void ShellSort(int[] arr){
        int h = 0;

        while(h<arr.length/3){
            h = h*3 + 1;
        }

        while(h>0){
            for(int i=h; i<arr.length; i++){
                int temp = arr[i];
                int j = i;
                while(j>h-1 && arr[j-h] > temp){
                    arr[j] = arr[j-h];
                    j -= h;
                }
                arr[j] = temp;
            }

            h = (h-1)/3;
        }
    }

}
