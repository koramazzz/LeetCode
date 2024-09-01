import java.util.Arrays;
import java.util.Comparator;

public class Two_Sum {
    public static void main(String[] args) {

        int[] nums = {2,11,7,15};
        int target = 26;

        Integer[] indexedArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexedArray[i] = i;
        }
        Arrays.sort(indexedArray, Comparator.comparingInt(i -> nums[i]));
        Arrays.sort(nums);

        int[] result = twoSum(nums,target);
        System.out.println(indexedArray[result[0]]);
        System.out.println(indexedArray[result[1]]);
    }
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i<nums.length; i++){
            int n = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] == target - n) return new int[]{i, j};
            }
        }
        return new int[]{0};
    }
}