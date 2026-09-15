import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean exploded = false;
            
            // Collision happens only when stack top moves right (> 0) and current moves left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // Top asteroid explodes, continue checking next top
                    continue;
                } else if (stack.peek() == -a) {
                    stack.pop(); // Both asteroids explode
                }
                exploded = true; // Current asteroid exploded
                break;
            }

            if (!exploded) {
                stack.push(a);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}