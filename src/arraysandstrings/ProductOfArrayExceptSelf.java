package arraysandstrings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        // output  =  24, 12, 8 , 6
        // 24 = 2*3*4
        // 12 = 1*3*4
        // 8 = 1*2*4
        // 6 = 1*2*3
    }


    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {   // counts up to 4
            result[i] = result[i - 1] * nums[i - 1];  // result = 1, result = 1, 1, result = 1, 1, 2, 6
        }
        System.out.println(Arrays.toString(result));

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;  // result = 1,1,2,6    1,1,8,6   1,12,8,6 24,12,8,6
            rightProduct *= nums[i]; // 4 // 12 // 24 // 24
        }

        return result;
    }

}
