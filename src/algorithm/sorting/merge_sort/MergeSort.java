package algorithm.sorting.merge_sort;

import java.util.Arrays;

/**
 * Created by lyn
 * 2018年11月12日10:51:57
 */
@SuppressWarnings("unchecked")
public class MergeSort {
    // 不允许实例化此类
    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        int len = arr.length;
        sort(arr, 0, len - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;  // 防止整型溢出
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 此优化对于近乎有序的数组非常有效，对于随机数组反而会有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    /**
     * 归并arr[l, mid]和arr[mid+1, r]
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        // 开辟一个辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 定义三个索引跟踪变量：i,j,k
        // i和j分别指向拷贝数组aux的左半部分和右半部分的起始索引(需要减去偏移量l)
        // k存储原数组的索引
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {              // aux的左半部分[l-l, mid-l]元素已被全部遍历
                arr[k] = arr[j - l];
            } else if (j > r) {         // aux的右半部分[mid+1-l, r-l]元素已被全部遍历
                arr[k] = arr[i - l];
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // i所跟踪的元素小于j跟踪的元素
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) >= 0) { // i所跟踪的元素大于等于j跟踪的元素
                arr[k] = aux[j - l];
                j++;
            }

        }
    }

}
