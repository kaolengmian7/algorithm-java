package src;

public class DynamicArray<E> {
    private int size;
    private E[] data;

    // 默认无参构造方法
    public DynamicArray(){
        this.data = (E[]) new Object[10];
        this.size = 0;
    }

    // 有参构造方法，初始化时配置数组的容量
    public DynamicArray(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int getCapacity(){
        return this.data.length;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    // ------- 增 ---------
    // 在 index 位置新增一个元素 e
    public void add(int index, E e){
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (this.size == this.data.length) {
            this.resize(this.data.length * 2);
        }

        for (int i = size-1; i >= index; i--) {
            this.data[i+1] = this.data[i];
        }
        this.data[index] = e;
        this.size++;

    }

    public void addLast(E e){
        this.add(size, e);
    }

    public void addFirst(E e){
        this.add(0, e);
    }

    // ------- 删 ---------
    public E remove(int index){
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }

        E e = data[index];
        for (int i = index; i < this.size; i++) {
            data[i] = data[i+1];
        }
        size--;
        if (this.size < this.data.length / 4 && this.data.length > 2) {
            this.resize(this.data.length / 2);
        }
        return e;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    // ------- 改 ---------
    public void set(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index <= size.");
        }
        this.data[index] = e;
    }

    // ------- 查 ---------
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index <= size.");
        }
        return this.data[index];
    }

    public boolean contains(E e){
        for (E item: data){
            if (item.equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
}
