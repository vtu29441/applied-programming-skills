import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store key-value pairs: element -> next greater element
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // Stack to maintain a decreasing monotonic order
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 to find next greater element for all items
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // Elements remaining in stack have no next greater element (-1 default)
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        
        // Build the result array for nums1 using precalculated values
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}