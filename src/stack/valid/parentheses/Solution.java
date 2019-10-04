package stack.valid.parentheses;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by 卜庆硕 on 2019/7/21.
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }else if (c == '}' && topChar != '{'){
                    return false;
                }else if (c == ']' && topChar != '['){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{}[]()";
        Solution solution = new Solution();
        System.out.println(solution.isValid(str));
    }
}
