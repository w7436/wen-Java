import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/16 18:44
 * @Version 1.0
 **/



public class Test {
    //数组的定义
    public static void main3(String[] args) {
        //length是方法的属性，遍历数组
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 2, 3, 4, 5};//new产生一个对象，引用存放对象de地址
        int[] array3 = new int[5];//当定义好数组之后，未初始化，则为0，如果是引用类型就是NULL


        //采用for循环
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        //foreach
        for (int x : array1) {//不能用下标去访问
            System.out.print(x + " ");
        }
        //采用字符串的形式打印
        System.out.println(Arrays.toString(array1));//将数组以字符串的形式打印
        //区别：对于foreach来说，不能用下标访问
        //当定义好数组之后没有初始化，默认值为0，数组当中如果是引用类型就是null
    }


    //数组作为参数
    public static void func(int x){
        x=10;
    }
    public static void func2(int []array){
        array[0]=99;
    }

    //数组作为返回值
    public static int[] fun3(){
        int []array={1,2,3,4,5};
        return array;
    }
    public static void main9(String[] args) {
        int []array={1,2,3,4,5};
        int a=20;
        System.out.println(a);//20
        func(a);
        System.out.println(a);//20

        func2(array);
        System.out.println(array[0]);//99

        int[] ret=fun3();
        for (int x : ret) {//不能用下标去访问
            System.out.print(x + " ");
        }
    }

//空指针异常
    public static void main11(String[] args) {
//        int array[]=null;
//        System.out.println(array);
//        System.out.println(array.length);
        String str=null;
        System.out.println(str.length());
    }

    //最大值
    public static int Max(int []array){
        int max=array[0];
        for (int x:array) {
            if(max<x) {
                max = x;
            }
        }
        return max;
    }
    //最小值
    public static int Min(int []array){
        int min=array[0];
        for (int x:array) {
            if (min >x) {
                min=x;
            }
        }
        return min;
    }
    //平均值
    public static float Aver(int []array){
        int sum=0;
        float aver=0f;
        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        aver=sum/array.length;
        return aver;
    }
    //逆置
    public static int[] Inverse(int []array) {
        int i=0;
        int j=array.length-1;
        int tmp=0;
        while (i<j){
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
            i++;
            j--;
        }
        return array;
    }
    //奇数往前
    public static int[] Oddup(int []array) {
        int left=0;
        int right=array.length-1;
        while(left<right){
            while(left<right&&array[left]%2!=0){
                left++;
            }
            while(left<right&&array[right]%2==0){
                right--;
            }
            if (left<right){
                int tmp=array[left];
                array[left]=array[right];
                array[right]=tmp;
            }
        }
        return array;
    }

    public static void main1(String[] args) {
        int []array={1,2,3,4,5,6};
        System.out.println(Max(array));
        System.out.println(Min(array));
        System.out.println(Aver(array));
        System.out.println (Arrays.toString (Inverse(array)));//将数组以字符串的形式打印
        System.out.println (Arrays.toString (Oddup(array)));//将数组以字符串的形式打印

    }



//二分法(递归)
    public static int binarySearch1(int[] array, int left, int key, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] > key) {
            return binarySearch1(array, 0, key, mid - 1);
        }
        if (array[mid] < key) {
            return binarySearch1(array, mid + 1, key, right);
        }
        if (array[mid] == key) {
            return mid;
        }
        return -1;
    }
    //二分法（非递归）
    public static int binarySearch(int []array,int key){
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if (array[mid]<key){
                left=mid+1;
            }else if (array[mid]>key){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array,4));
    }






    public static int[] bubbleSort(int []array){
        boolean flg=false;//不初始化默认值为false
        for (int i = 0; i <array.length-1 ; i++) {
            flg=false;
            for (int j = 0; j <array.length-1-i ; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flg=true;
                }
            }
            if (!flg){
                return array;
            }
        }
        return array;
    }
    public static void main4(String[] args) {
        int []array=new int[]{1,4,2,5,7,4};
        System.out.println(Arrays.toString( bubbleSort(array)));
    }



    //数组的拷贝
    //模拟实现Arrays.copyOf
    public static int[] copyArray(int[] ori,int length){
        int[] ret=new int[length];
        for (int i = 0; i <length-1 ; i++) {
            ret[i]=ori[i];
        }
        return ret;
    }
    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int [] array2=new int[array.length];

        //采用循环
        for (int i = 0; i <array.length ; i++) {
            array2[i]=array[i];
        }
        System.out.println(Arrays.toString(array2));
        //采用arraycopy方法
        System.arraycopy(array,0,array2,0,array.length);
        System.out.println(Arrays.toString(array2));
        //采用Array.copyof----->有返回值
        array2=Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(array2));
        //采用array.clone------>有返回值
        array2=array.clone();
        System.out.println(Arrays.toString(array2));

    }


    //打印字符串形式的数组[2,4,6.8,10]
    public static String toString(int[] array){
        String ret="[";
        for (int i = 0; i <array.length ; i++) {
            ret+=array[i]*2;//后期讲解
            if (i!=array.length-1){
                ret+=",";
            }
        }
        ret+="]";
        return ret;
    }
    public static void main6(String[] args) {
        int []array={5,3,2,4,5};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int ret=binarySearch(array, 3);
        System.out.println(toString(array));
        System.out.println(ret);
    }

    //Arrays工具类的使用
    /**
     * Arrays.copyOfRange拷贝部分
     * Arrays.equals(array,array2);判断相等
     * Arrays.fill(array,9);全部填充为9
     * Arrays.fill(array,2,7,9);[2,7)填充为9
     * Arrays.sort(array);对数组进行排序
     *
     * 面试：Arrays.sort底层是什么排序
     *
     * Arrays.toString();
     * Arrays.deepToString();
     */
    public static void main7(String[] args) {
        int []array=new int[5];
        System.out.println(Arrays.toString(array));
        Arrays.fill(array,2,3,9);
        System.out.println(Arrays.toString(array));
        int []array2={12,5,7,8,4,90,43};
        System.out.println(Arrays.toString(array2));
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
//二维数组
    public static void main8(String[] args) {
        int[][] array={{1,2},{3,4},{5,6}};
        int [][] array2=new int[][]{{1,2},{3,4},{5,6}};
        int [][] array3=new int[3][2];

        //不规则的二维数组
        int [][] array4=new int [3][];
        int[][] array5={{1},{3,4},{5,6}};

        System.out.println("长度1；"+array5.length);
        System.out.println("长度2："+array5[0].length);
        System.out.println("长度3："+array5[1].length);

        //二维数组打印
        for (int i = 0; i <array5.length ; i++) {
            for (int j = 0; j <array5[i].length ; j++) {
                System.out.print(array5[i][j]+" ");
            }
            System.out.println();
        }
        //二维数组按照字符串的形式打印
        System.out.println(Arrays.deepToString(array5));

    }
    //可变参数编程
    public static int sum(int... a){
        int ret=0;
        for (int x:a){
            ret+=x;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5));//匿名数组
        int[] arr={1,2,3,4,5};
        System.out.println(sum(arr));//匿名数组

    }
}