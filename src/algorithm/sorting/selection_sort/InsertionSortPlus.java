package algorithm.sorting.selection_sort;

/**
 * Created by lyn
 */
public class InsertionSortPlus {
    // 不允许实例化此类
    private InsertionSortPlus() {
    }

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr) {

        int len = arr.length;
        for (int i = 1; i < len; i++) {

            // 寻找元素arr[i]合适的插入位置
            int j;  // j变量保存着元素arr[i]最终应该插入的位置
            for (j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;  // 提前终止内存循环
                }
            }
            if (j != i) {
                arr[j] = arr[i];
            }

        }

    }
}
