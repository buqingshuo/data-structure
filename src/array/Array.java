package array;

/**
 * Created by 卜庆硕 on 2019/7/21.
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造方法，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty(){
        return size ==0;
    }

    /**
     * 向所有元素后添加一个元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 向所有元素前添加一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 获得数组中最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获得数组中第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }


    /**
     * 在index位置插入一个元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        // 判断传入的索引index是否符合规范
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size.");
        }

        // 判断数组是否已满
        if (data.length == size){
            resize(size * 2);
        }

        // 将要插入位置的元素及其后元素一次后移一位
        for (int i = size -1; i >= index; i --){
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    /**
     * 获取索引index位置上的元素
     * @param index
     * @return
     */
    public E get(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改索引index位置上的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){

        for (int i = 0; i < size ; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，若不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size ; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回被删除的元素
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size ; i++) {
            data[i - 1] = data[i];
        }
        size --;

        if (size == data.length / 4){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中的第一个元素，并返回被删除元素
     * @return
     */
    public E removeFirst(){

        return remove(0);
    }

    /**
     * 删除数组中最后一个元素，并返回被删除元素
     * @return
     */
    public E removeLast(){

        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("array.array size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size ; i++) {
            res.append(data[i]);
            if (i != size -1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
