package data_structure.queue;

import data_structure.heap.MinHeap;

public class PriorityQueue<E extends Comparable<E>> {
    private MinHeap<E> eMinHeap;

    public PriorityQueue() {
        eMinHeap = new MinHeap<>();
    }
}
