package sort;

/**
 * 测试排序算法的实用方法
 *
 * @author dean
 */
public class SortTestUtil {

    /* 不允许产生实例对象 */
    private SortTestUtil() {
    }

    /**
     * [rangeL, rangeR]
     * [0, rangeR - rangeL]
     * 0 <= x * (rangeR - rangeL) < rangeR - rangeL
     * 0 <= x * (rangeR - rangeL + 1) <= rangeR -rangeL
     * rangeL <= x * (rangeR - rangeL + 1) + rangeL <= rangeR - rangeL + rangeL
     * rangeL <= x * (rangeR - rangeL + 1) + rangeL <= rangeR
     * <p>
     * 生成含有 n 个元素的随机数组，每个元素的随机范围是：[rangeL, rangeR]
     *
     * @param n      数组长度
     * @param rangeL 随机范围的最小值
     * @param rangeR 随机范围的最大值
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }

        return arr;
    }

}
