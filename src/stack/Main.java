package stack;

/**
 * Created by 卜庆硕 on 2019/7/21.
 */
public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for(int i=0 ; i < 6; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
