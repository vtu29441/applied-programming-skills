class Solution {
    public int[] runningSum(int[] nums) {
        // Start from index 1 because the running sum at index 0 is just nums[0]
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}