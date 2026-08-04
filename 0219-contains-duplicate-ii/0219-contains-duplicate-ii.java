import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element was seen in the last k elements
            if (window.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to our sliding window
            window.add(nums[i]);
            
            // Maintain sliding window size <= k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}