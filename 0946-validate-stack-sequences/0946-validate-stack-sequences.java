class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array

        for (int val : pushed) {
            stack.push(val); // Push current element onto the stack

            // Pop elements from the stack while top matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, all elements were successfully pushed and popped
        return stack.isEmpty();
    }
}