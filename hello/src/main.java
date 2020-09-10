/**
 * @ClassName main
 * @Description 排序算法
 * @Author DELL
 * @Data 2020/7/23 16:26
 * @Version 1.0
 **/

public class main {
    /**冒泡排序：比较相邻的两个元素，进行交换，每一趟就排好一个数字
     * 倘若有n个元素，则需要进行n-1趟排序，每一趟比较n-i次，外层的循环控制趟数，内部的循环控制比较的次数
     * 稳定
     * O(n^2)  O(1)
     */
    private static void bubbleSort(int[] arr){
        //控制趟数
        boolean flg = false;
        for(int i = 0;i < arr.length-1;i++){
            //控制比较的次数
            for(int j = 0;j < arr.length-1-i;j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flg = true;
                }
            }
            if(!flg){
                break;
            }
        }
    }

    /**
     *插入排序：类似于插牌的过程，在其那面已经排好序的过程中插入即将要排入的元素
     * 每步将一个待排序的元素插入到前面已经排好的元素，直到所有的元素排序完成
     * O(n^2) O(1)
     * 稳定
     */
    public static void insertSort(int[] arr) {
        //插入的次数
        for(int i = 1;i < arr.length;i++) {
            int key = arr[i];
            //寻找插牌的位置
            int end = i-1;
            while(end >= 0 && arr[end] > key) {
                arr[end+1] = arr[end];
                end--;
            }
            arr[end+1] = key;
        }
    }
    //利用折半插入的思想
    public static void insertSortOP(int[] arr) {
        for(int i = 1;i < arr.length;i++) {
            int key = arr[i];
            int left = 0;
            int right = i-1;
            //寻找插入的位置
            while(left <= right) {
                int mid = left + (right-left)/2;
                if(arr[mid] > key) {
                    right = mid -1;
                }
                if(arr[mid] < key) {
                    left = mid + 1;
                }
                if(arr[mid] == key) {
                    left = mid + 1;
                    break;
                }
            }
            //将元素向后移动一位
            while(left < i) {
                arr[i] = arr[i-1];
                i--;
            }
            arr[left] = key;
        }
    }
    /**
     * 希尔排序：在插入排序的基础上将元素进行分类
     * 取一个整数n作为间隔将数组分为n组，所有距离n的元素放在一个组中，在每一个组中进行插入排序，直到n为1
     * 关于n的取值：
     * shell最初是n/2向下取整，直到n为1
     * knuth提出n/3+1向下取整
     */
    private static void shellSort(int[] arr) {
        int gap = arr.length;
        while(gap > 1) {
            gap = gap / 3 + 1;
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int end = i - gap;
                while (end >= 0 && key < arr[end]) {
                    arr[end + gap] = arr[end];
                    end -= gap;
                }
                arr[end + gap] = key;
            }
        }
    }
    /**
     * 选择排序:每次选择最大或者最小的元素放在数组的最后的位置
     */
    public static void selectSort(int[] arr) {
        for(int i = 0;i < arr.length - 1;i++) {
            int maxPos = 0;
            for(int j = 1;j < arr.length-i;j++) {
                if(arr[maxPos] < arr[j]){
                    maxPos = j;
                }
            }
            if(maxPos != arr.length-1-i) {
                swap(arr,maxPos,arr.length-1-i);
            }
        }
    }
    public static void selectSortOP(int[] arr) {
        int begin = 0,end = arr.length-1;
        while(begin < end) {
            int index = begin+1;
            int maxPos = begin;
            int minPos = begin;
            while(index <= end) {
                if(arr[maxPos] > arr[index] ) {

                }
            }
        }
    }
    //交换两个数字
    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    private static void printArr(int[] arr) {
        for(int x:arr) {
            System.out.printf(x+" ");
        }
    }
    public static void main(String[] args) {
        int[] array = {4,2,9,8,5,1,6,3,7};

//        bubbleSort(array);
//       insertSort(array);
//        insertSortOP(array);
        shellSort(array);
        printArr(array);
    }

}


