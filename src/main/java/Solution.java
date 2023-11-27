import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
//        for (int i=0; i<height.length; i++) {
//            for(int j = height.length-1; j>i; j--) {
//                int a = Math.min(height[i], height[j]);
//                int currentArea = a * (j - i);
//                maxArea = Math.max(maxArea, currentArea);
//                System.out.printf("max Area: %d - current Area %d \n", maxArea, currentArea);
//            }
//        }

        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int a = Math.min(height[left], height[right]);
            int currentArea = a * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            System.out.printf("left: %d - right: %d - ", left, right);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            System.out.printf("max Area: %d - current Area %d \n", maxArea, currentArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        int [] height = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
//        int result = solution.removeElement(a, 3);
//        System.out.println(result);
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
}