package queue.priority_queue;

public class PriorityQueue<E extends Comparable<E>> {

    private Array<E> data;

    public PriorityQueue(int capacity) {
        data = new Array<>(capacity);
    }

    public PriorityQueue() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
