package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/20 17:35
 * @Version 1.0
 **/
public class Main {
    /**
     * [1,2,3,4]
     * [5,6,7,8]
     * [9,10,11,12]
     * [13,14,15,16]
     *
     * 打印结果[4,3,8,2,7,12,1,6,11,16]
     * 从右上角到左下角按照主对角线进行打印
     */
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        List<Integer> l = new ArrayList<>();
        int[] a = new int[n*n];
        int x = 0;
        //右上角
        for(int y = n-1;y >= 0;y--){
            int i = x;
            int j = y;
            if(i !=0 && j != 0){
                l.add(arr[i][j]);
            }
            if(i != 0){
                j--;
            }
            while(i < n &&(j >=0 && j<n)){
                l.add(arr[i][j]);
                i++;
                j++;
            }
        }
        //左下角
        int y = 0;
        for(x = 1;x < n;x++){
            int i1 = x;
            int j1 = y;
            l.add(arr[i1][j1]);
            i1++;
            j1++;
            while(i1 < n &&(j1 >=0 && j1<n)){
                l.add(arr[i1][j1]);
                i1++;
                j1++;
            }
        }
        for(int i = 0;i < l.size();i++){
            a[i] = l.get(i);
        }
        return a;
    }
}
