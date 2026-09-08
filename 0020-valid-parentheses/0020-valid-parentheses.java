import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Strings with odd length can never be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push expected closing character onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or top character doesn't match current closing character
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Return true if all opening brackets were properly closed
        return stack.isEmpty();
    }
}