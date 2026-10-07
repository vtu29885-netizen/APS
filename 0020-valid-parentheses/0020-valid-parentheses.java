import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        // Create a map to store matching bracket pairs
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is a closing bracket
            if (bracketMap.containsKey(c)) {
                // Get the top element of the stack if it exists; otherwise use a dummy char
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                
                // If the top element doesn't match the required opening bracket, it's invalid
                if (topElement != bracketMap.get(c)) {
                    return false;
                }
            } else {
                // It is an opening bracket, push it onto the stack
                stack.push(c);
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
