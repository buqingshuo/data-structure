package stack;

/**
 * Created by 卜庆硕 on 2019/7/21.
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
