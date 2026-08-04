class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // rightSum is totalSum minus leftSum minus the current element
            int rightSum = totalSum - leftSum - nums[i];
            
            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - (n - 1 - i) * nums[i];
            
            result[i] = leftTotal + rightTotal;
            
            // Update leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}