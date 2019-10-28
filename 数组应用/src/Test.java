import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/27 23:04
 * @Version 1.0
 **/
public class Test {
    public static void removeDuplicates(int[] nums) {
        int count=0;
        for (int i = 1; i <nums.length ; i++) {
            int tmp=nums[count];
           if (tmp!=nums[i]){
                nums[++count]=nums[i];
            }
        }
        for (int i = 0; i <=count ; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums={1,1,2,2,3};
        removeDuplicates(nums);
        //System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
