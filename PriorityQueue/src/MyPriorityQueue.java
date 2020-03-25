import sun.plugin.cache.OldCacheEntry;

import java.util.Arrays;

/**
 * @ClassName MyPriorityQueue
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/25 9:32
 * @Version 1.0
 **/
interface Comp{
    public int compare(int left,int right);
}
class Less implements Comp{
    public int compare(int left,int right){
        return left - right;
    }
}
class Greater implements Comp{
    public int compare(int left,int right){
        return right-left;
    }
}


public class MyPriorityQueue {
    private int[] array;
    //不能用array.length表示有效元素的个数，因为length表示数组的大小
    private int size;
    Comp comp = null;

    public MyPriorityQueue(Comp mp) {
        array = null;
        comp =mp;

    }
    public MyPriorityQueue(int initCapacity,Comp mp){
        if (initCapacity < 1){
            //标准库：抛出一个非法参数异常
            initCapacity = 11;
        }
        array = new int[initCapacity];
        comp = mp;
    }
    //标准库中没有该接口，标准库中可以采用集合类构造
    public MyPriorityQueue(int[] arr,Comp mp){
          array = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
            array[i] = arr[i];
        }
        size = arr.length;
        comp = mp;
        //将array的元素调整，让其满足小堆的性质
        //找倒数第一个非叶子结点
        int lastLeaf = (array.length-2)>>1;
        for (int root = lastLeaf;root>=0;root--){
            shifDown(root);
        }

    }

    //获取堆顶元素
    int peek(){
        //标准库中，如果没有堆顶元素，返回null
        return array[0];
    }

    boolean offer(int x){
        grow();
        //将元素插入到数组中
        array[size++] = x;
        shiftUp(size-1);
        return true;
    }

    //扩容
    private void grow() {
        if (size >= array.length){
            int oldCapacity = array.length;
            int newCapacity = oldCapacity + ((oldCapacity <64)?(oldCapacity+2):(oldCapacity>>1));
            array = Arrays.copyOf(array,newCapacity);
        }

    }


    //每次删除堆顶的元素
    int poll(){
        int ret = array[0];
        swap(0,size-1);
        size--;
        shifDown(0);

        return 0;
    }
    boolean isEmpty(){
        return 0 == size;
    }
    void clear(){
        size = 0;
    }
    //参数为本次需要调整的结点的小标
    //在调整之前确保其左右子树已经满足小堆的性质
    //如果检测parent是否满足小堆的性质，只需要与其孩子进行比较
    //满足小堆的性质---》说明以parent为根的二叉树已经是小堆
    //不满足小堆的性质---》说明parent比起孩子结点大，此时需要将parent与其较小的孩子进行交换
    //                      交换完以后，parent较大的元素向下移动，可能导致其子树不满足小堆的性质
    //                       需要继续调整子树

    public void shifDown(int parent){
        //使用child标记parent的较小的孩子
        //默认情况下先标记左孩子，因为可能没有右孩子
        int child = parent*2+1;
        int size = array.length;
        while (child < size){
            //保证右孩子存在
//            if (child+1 <size && array[child+1] < array[child]){
            if (child + 1 < size && comp.compare(array[child+1] ,array[child])<0){
                child+=1;
            }
            //检测较小孩子是否比双亲小
          if (comp.compare(array[child] ,array[parent]) <0){
            //说明不满足小堆的性质
            swap(parent,child);
            //parent较大的元素向下调整,可能会引起其他的子树不满足小堆的性质
            parent = child;
            child = parent*2+1;
          } else {
              return;
          }
        }
    }


    public void shiftUp(int child){
        int parent = (child-1)>>1;
        while (parent>=0) {
            if (comp.compare(array[child],array[parent]) < 0) {
                swap(parent, child);
                //较小的孩子和双亲后，可能会导致上层不满足小堆的性质
                child = parent;
                parent = (child - 1) >> 1;
            } else {
                return;
            }
        }
    }
    private void swap(int parent ,int child){
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public static void main(String[] args) {
        int array[]={5,3,7,1,4,6,8,0,2};
        MyPriorityQueue mp= new MyPriorityQueue(array,new Greater());
        mp.offer(9);
        System.out.println(mp.peek());
        System.out.println(mp.size);


        mp.offer(-1);
        System.out.println(mp.peek());

        mp.poll();
        System.out.println(mp.peek());

        mp.clear();
        if (mp.isEmpty()){
            System.out.println("为空");
        }
        else{
            System.out.println("不为空");
        }



    }
}



























