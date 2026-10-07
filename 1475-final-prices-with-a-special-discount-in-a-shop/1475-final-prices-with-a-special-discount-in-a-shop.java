import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int indexToDiscount = stack.pop();
                prices[indexToDiscount] -= prices[i];
            }
            
            stack.push(i);
        }
        
        return prices;
    }
}
