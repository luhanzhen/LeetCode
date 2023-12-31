import java.util.Stack;

public class valid_parentheses {
    public static void main(String[] args) {


        System.out.println(new Solution().isValid("()[]{}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '[' || c == '{')
                {
                    stack.push(c);

                }else if(c == ')' )
                {
                    if(stack.isEmpty())
                        return false;
                    char top = stack.pop();
                    if(top != '(')
                        return false;
                }else if( c == ']' )
                {
                    if(stack.isEmpty())
                        return false;
                    char top = stack.pop();
                    if(top != '[')
                        return false;
                }else if( c == '}')
                {
                    if(stack.isEmpty())
                        return false;
                    char top = stack.pop();
                    if(top != '{')
                        return false;
                }else
                {
                    return false;
                }
            }
            return stack.isEmpty();
        }

    }
}
