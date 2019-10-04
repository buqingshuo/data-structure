package queue;

/**
 * Created by 卜庆硕 on 2019/7/21.
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
