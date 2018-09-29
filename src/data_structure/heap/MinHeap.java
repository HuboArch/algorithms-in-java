package data_structure.heap;

import data_structure.linear_list.ArrayList;

import java.util.Comparator;

public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> data;
    private int size = 0;
    private final Comparator<? super E> comparator;

    public MinHeap() {
        this(null);
    }

    public MinHeap(int initialCapacity) {
        this(initialCapacity, null);
    }

    public MinHeap(Comparator<? super E> comparator) {
        this.data = new ArrayList<>();
        this.comparator = comparator;
    }

    public MinHeap(int initialCapacity, Comparator<? super E> comparator) {
        this.data = new ArrayList<>(initialCapacity);
        this.comparator = comparator;
    }
}
