package algorithm.sorting.selection_sort;

public class SelectionSort {

    // 此类不能实例化
    private SelectionSort() {
    }

    /**
     * 排序功能实现
     *
     * @param arr 数组
     */
    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            // 寻找[i, n)区间内最小值的索引
            int minIdx = i;
            Comparable curItem = arr[minIdx];
            for (int j = i + 1; j < len; j++) {
                if (arr[j].compareTo(curItem) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }

        }
    }

    /**
     * 数组元素值互换
     *
     * @param arr 数组
     * @param i   索引
     * @param j   索引
     */
    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];

        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
