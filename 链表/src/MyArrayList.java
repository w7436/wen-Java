import com.sun.glass.ui.Size;

import java.util.Arrays;

/**
 * @ClassName MyArrayList
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/27 11:15
 * @Version 1.0
 **/
class MyArrayList {
    public final int CAPACITY =10;
    public int usedSize;
    public int[] elem;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
    //判断是否需要扩容
    private void judge(){
        int i=0;
        if(this.usedSize==elem.length){
            int[] newArr=new int[ this.elem.length*2];
            for(i=0;i<this.usedSize;i++){
                newArr[i]=elem[i];
            }
            elem=newArr;
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法(两个条件)
        if (pos<0||pos>this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }
        judge();
        //2、挪数据
        for (int i=usedSize;i>pos;i--){
            this.elem[i]=this.elem[i-1];
        }
        //3、插入数据
        this.elem[pos]=data;
        //4、usedSize++
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <this.usedSize; i++) {
            if (toFind==elem[i]){
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i=0;i<this.usedSize;i++){
            if (elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        for (int i = 0; i <this.usedSize ; i++) {
            if (i==pos){
                return elem[i];
            }
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {
        if (pos<0||pos>this.usedSize){
            System.out.println("位置不合法");
        }
         for (int i =this.usedSize-1; i >0 ; i--) {
            if (pos==i){
              elem[i]=value;
            }
         }
     }

    //删除第一次出现的关键字Remove
    public void remove(int toRemove) {
        if (this.usedSize==0){
            System.out.println("顺序表为空！");
        }
        int i=search(toRemove);
        if (i!=-1){
            for (int j=i;j<this.usedSize;j++) {
                elem[j] = elem[j + 1];
            }
            this.usedSize--;
        }
        else {
            System.out.println("该数不存在！");
        }

    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for (int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}