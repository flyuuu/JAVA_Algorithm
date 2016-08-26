package ynu.edu.fly.sort;


/**
 * 插入，冒泡，选择，快速，归并，堆排序
 * Created by fly on 16-8-19.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class SortUtil {
    private static Comparator cp;
    public static <T> void insertSort(List<T> list ,Comparator<T> cp){
        T[] ls=(T[]) list.toArray();
        T temp;
        for(int i=1,len=ls.length;i<len;i++){
            for(int j=i;j>0;j--){
                if(cp.compare(ls[j-1],ls[j])>0){
                    temp=ls[j-1];
                    ls[j-1]= ls[j];
                    ls[j]=temp;
                }else{
                    break;
                }
            }
        }
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<ls.length; j++) {
            i.next();
            i.set(ls[j]);
        }
    }
    /**
     * 相对比上面慢,读者可以自己试验一下，因为list.get（i) 开销比list[i]大
     */
    public static <T> void insertSort2(List<T> list ,Comparator<T> cp){
        T temp;
        for(int i=1,len=list.size();i<len;i++){
            for(int j=i;j>0;j--){
                if(cp.compare(list.get(j-1), list.get(j))>0){
                    temp=list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j,temp);
                }else{
                    break;
                }
            }
        }
    }
    public static <T> void bubbleSort(List<T> list,Comparator<T> cp){
        T[] ls=(T[]) list.toArray();
        T temp;
        for(int i=ls.length;i>0;i--){
            for(int j=1;j<i;j++){
                if(cp.compare(ls[j-1],ls[j])>0){
                    temp=ls[j];
                    ls[j]=ls[j-1];
                    ls[j-1]=temp;
                }
            }
        }
        ListIterator<T> i=list.listIterator();
        for(int j=0;j<ls.length;j++){
            i.next();
            i.set(ls[j]);
        }
    }

    public static <T> void selectSort(List<T> list,Comparator<T> cp){
        T[] ls=(T[]) list.toArray();
        T temp;
        for(int i=0,len=ls.length;i<len;i++){
            int k=i;
            for(int j=i+1;j<len;j++){
                if(cp.compare(ls[k],ls[j])>0)
                    k=j;
            }
            temp=ls[k];
            ls[k]=ls[i];
            ls[i]=temp;
        }
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<ls.length; j++) {
            i.next();
            i.set(ls[j]);
        }

    }
    /**quick sort**/
    public static <T> void quickSort(List<T> list,Comparator<T> cp){
        SortUtil.cp=cp;
        T[] ls=(T[]) list.toArray();
        partion(ls,0,list.size()-1);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<ls.length; j++) {
            i.next();
            i.set(ls[j]);
        }
    }
    public static <T> void partion(T[] list,int begin,int end){
        if(begin>=end) return;
        int i=begin,j=end;
        T pivot = list[begin];
        while(i<=j){
            while(SortUtil.cp.compare(list[j], pivot)>0&&i<j) j--;
            if(i==j)  break;
            list[i]=list[j];
            while(SortUtil.cp.compare(list[i], pivot)<=0&&i<j) i++;
            if(i==j)  break;
            list[j]=list[i];
        }
        list[i]=pivot;
        partion(list,begin,i-1);
        partion(list,i+1,end);
    }
    /**merge sort**/
    public static <T> void mergeSort(List<T> list,Comparator<T> cp){
        SortUtil.cp=cp;
        T[] ls=(T[]) list.toArray();
        mergeSort(ls, 0, ls.length-1);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<ls.length; j++) {
            i.next();
            i.set(ls[j]);
        }
    }
    private static<T> void mergeSort(T[] list,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(list,l,m);
            mergeSort(list,m+1,r);
            merge(list,l,m,r);
        }
    }
    private static<T> void merge(T[] list,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        T[] L=(T[]) new Object[n1];
        T[] R=(T[]) new Object[n2];
        int i,j;
        for(i=0;i<n1;i++)
            L[i]=list[l+i];
        for(j=0;j<n2;j++)
            R[j]=list[m+j+1];
        i=j=0;
        for(int k=l;k<=r;k++){
            if(j==n2||i!=n1&&SortUtil.cp.compare(L[i],R[j])<=0){
                list[k]=L[i];
                i++;
            }else{
                list[k]=R[j];
                j++;
            }
        }
    }
    /**heap sort**/
    public static<T> void heapSort(List<T> list,Comparator<T> cp){
        SortUtil.cp=cp;
        T[] ls=(T[]) list.toArray();
        HeapList hList=new HeapList(ls);
        buildMaxHeap(hList);
        for(int i=hList.heapSize-1;i>=1;i--){
            Object temp= hList.arr[0];
            hList.arr[0]=hList.arr[i];
            hList.arr[i]=temp;
            hList.heapSize--;
            maxHeapify(hList, 0);
        }
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<ls.length; j++) {
            i.next();
            i.set(ls[j]);
        }
    }
    public static void buildMaxHeap(HeapList a){
        for(int i=a.heapSize>>1-1;i>=0;i--){//>>1表示除以2
            maxHeapify(a, i);
        }
    }
    public static void maxHeapify(HeapList a,int i){
        int l=2*i+1;//left leaf
        int r=2*i+2;//right leaf
        int largest;
        if(l<a.heapSize&&SortUtil.cp.compare(a.arr[l],a.arr[i])>0){
            largest=l;
        }else{
            largest=i;
        }
        if(r<a.heapSize&&SortUtil.cp.compare(a.arr[r],a.arr[largest])>0){
            largest=r;
        }
        if(largest!=i){
            Object temp=a.arr[i];
            a.arr[i]=a.arr[largest];
            a.arr[largest]=temp;
            maxHeapify(a,largest);
        }
    }
    private static class HeapList<T>{
        public T[] arr;
        public int heapSize;
        public HeapList(T[] arr){
            this.arr= arr;
            this.heapSize=arr.length;
        }
    }
    public static final int SIZE=1000;
    public static void main(String[] args){
        ArrayList<Integer> al=new ArrayList<>();
        Random ra=new Random();
        for(int i=0;i<SIZE;i++){
            al.add(ra.nextInt(SIZE));
        }

        long start1=System.currentTimeMillis();
        SortUtil.mergeSort(al,new IntegerCondition<Integer>());
        long end1=System.currentTimeMillis();
        System.out.println("cost time:"+(end1-start1)+" milliseconds");


        for(Integer elem:al){
            System.out.println(elem);
        }
        List<String> strList=new ArrayList<String>();
        strList.add("f");
        strList.add("d");
        strList.add("g");
        strList.add("a");
        SortUtil.bubbleSort(strList,new StringCondition<String>());
        for(String elem:strList){
            System.out.println(elem);
        }
    }
}
/**
 * the absolute value of elem must not bigger than Integer.MAX_VALUE/2.
 * 11 12 5 28 92 9 8
 * @author keepthinker
 *
 * @param <Integer>
 */
class IntegerCondition<Integer> implements Comparator<Integer>{
    @Override
    public int compare(Integer arg0, Integer arg1) {
        // TODO Auto-generated method stub
        int a1=(java.lang.Integer) arg0;
        int a2=(java.lang.Integer) arg1;
        return  (a1-a2);
    }

}
class StringCondition<String> implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        return ((java.lang.String)o1).compareTo((java.lang.String)o2);

    }

}


