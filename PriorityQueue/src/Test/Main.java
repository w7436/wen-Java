package Test;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/29 11:14
 * @Version 1.0
 **/
public class Main {
    public static void createHeap(int[] nums,int heapSize){
        //找到最后一个叶子结点，进行向下调整，直到根节点
        int leaf = (heapSize - 2)>>1;
        for(int i = leaf;i >= 0; i--){
            sink(i,nums,heapSize);
        }
    }
    public static void sink(int parent,int[] nums,int heapSize){
        //标记其左孩子结点
        int child = parent*2+1;
        while(child < heapSize){
            //代表有存在右孩子结点，并且符合条件
            if(child + 1 < heapSize && nums[child] < nums[child+1]){
                child+=1;
            }
            //判断父结点和孩子结点
            if(nums[parent] < nums[child]){
                swap(parent,child,nums);
                //交换之后可能导致子树不满足大堆的性质
                parent = child;
                child = parent*2+1;
            }else{
                return;
            }
        }
    }
    public static void swap(int parent,int child,int[] nums){
        int tmp = nums[parent];
        nums[parent] = nums[child];
        nums[child] = tmp;
    }
    public static int findKthLargest(int[] nums, int k) {
        //创建一个大根堆
        int heapSize = nums.length;
        createHeap(nums,heapSize);
        for (int i = nums.length -1; i >= nums.length - k + 1; --i) {
            swap( 0,i,nums);
            --heapSize;
            createHeap(nums,heapSize);
        }
        return nums[0];
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int m = findKthLargest(arr,1);
        System.out.println(m);
    }
}
