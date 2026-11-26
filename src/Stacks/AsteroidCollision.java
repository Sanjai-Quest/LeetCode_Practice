package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    static int[] Collision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids) {
            boolean isDestroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if(stack.peek() < Math.abs(a)) stack.pop();
                else if(stack.peek() == Math.abs(a)) {
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }
            if(!isDestroyed) stack.push(a);
        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(Collision(asteroids)));
    }

}
