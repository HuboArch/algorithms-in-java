package queue.linkedlist;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list;

    public LinkedListQueue() {
        this.list = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E peekHead() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "Queue: " + list;
    }
}
