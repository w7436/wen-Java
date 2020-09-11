/**
 * @ClassName Sort
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/26 19:53
 * @Version 1.0
 **/
public class Sort {


    public static void selectSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int maxPos = 0;
            for (int j = 1; j < array.length - i  ; j++) {
                if (array[maxPos] <array[j]){
                    maxPos = j;
                }
            }
            if (array.length -1 -i != maxPos){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }

    public static void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    //O（N^1.25）~O(1.6N^1.25)
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            gap = gap/3+1;//每次可以除2，每次取素数
            for (int i = gap; i < array.length; i++) {
                int key = array[i];
                int end = i - gap;
                while(end > 0 && key < array[end]){
                    array[end+gap] = array[end];
                    end-=gap;
                }
                array[end+gap] = key;
            }
          //  gap--;
        }
    }
    public static void insertSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int end = i - 1;
            while(end >= 0 && key < array[end]){
                array[end+1] = array[end];
                end--;
            }

            array[end+1] = key;
        }
    }
    public static void print(int[] array){
        for(int e : array){
            System.out.println(e + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        insertSort(array);
        print(array);
    }
}
