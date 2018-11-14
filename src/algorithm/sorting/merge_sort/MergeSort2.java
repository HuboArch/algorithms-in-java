package algorithm.sorting.merge_sort;

import java.util.Arrays;

/**
 * Created by lyn
 */
@SuppressWarnings("unchecked")
public class MergeSort2 {

    // 不允许实例化此类
    private MergeSort2() {
    }

    /**
     * 归并arr[l, mid]和arr[mid+1, r]
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int sz = 1; sz < n; sz += sz) {

            for (int i = 0; i < n - sz; i += sz + sz) {
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    MergeSort.merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }

        }
    }
}
