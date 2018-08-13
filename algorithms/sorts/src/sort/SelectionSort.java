package sort;

public class SelectionSort {

    // 此类不能实例化
    private SelectionSort() {
    }

    /**
     * 排序功能实现
     *
     * @param arr 数组
     */
    public static void sort(Comparable[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int minIdx = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
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
