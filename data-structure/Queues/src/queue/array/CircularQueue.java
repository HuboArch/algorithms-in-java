package queue.array;

public class CircularQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * 判断队列是否为空
     *
     * @return 若为空返回 true
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断队列是否已满
     *
     * @return 若已满返回 true
     */
    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peekFront() {
        return null;
    }
}
