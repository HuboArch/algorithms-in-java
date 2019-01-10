package algorithm.sorting.heap_sort;

import data_structure.heap.MinHeap;

/**
 * @author Hubo
 * Project: algorithms-in-java
 * Time: 2019/1/10 10:50
 * Email: hkissbigapple@163.com
 */
public class HeapSort2 {

    public static void sort(Comparable[] arr) {

        // 使用 heapify 的方式，将数组元素加入堆中这一环节的时间复杂度由 O(nlogn) 优化为 O(n)
        MinHeap<Comparable> heap = new MinHeap<>(arr);

        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = heap.poll();
        }
    }

}
