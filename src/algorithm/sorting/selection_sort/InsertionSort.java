package algorithm.sorting.selection_sort;

/**
 * Created by lyn
 */
public class InsertionSort {
    /**
     * 不允许实例化此类
     */
    private InsertionSort() {
    }

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {

            // 确定元素arr[i]应该插入的位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    // 插入排序具有提前终止内层循环的能力
                    break;
                }
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
