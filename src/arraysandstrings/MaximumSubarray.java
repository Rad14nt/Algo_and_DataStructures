import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarray {


    public static void main(String[] args) {
        int[] nums = {-1, -3, -2};
    }

    public static int maxSubArray(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num: nums){
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
