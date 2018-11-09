/**
 * Created by lyn
 */
@SuppressWarnings("unchecked")
public class TestDemo {
    public static void main(String[] args) {

    }

    public void selectionSort(Comparable[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            int minIdx = i;
            Comparable curItem = arr[minIdx];
            for (int j = 1; j < len; j++) {
                if (arr[j].compareTo(curItem) < 0) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }

    }

    private void swap(Comparable[] arr, int a, int b) {
        Comparable tmp = arr[a];

        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
