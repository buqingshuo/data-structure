package queue;

import array.Array;

/**
 * Created by 卜庆硕 on 2019/7/21.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    // front指向队首所在索引，tail指向队列最后一个元素的下一个位置
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 将原数组中的所有元素放到新的数组中
        // 将原数组中索引为front的元素放在新数组的第一个位置
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size; // 扩容操作并不影响元素个数，size不必重新赋值
    }
}
