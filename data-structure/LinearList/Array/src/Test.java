public class Test {
    /**
     * 测试顺序存储的线性表
     */
    public static void main(String args[]) {
        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++) {
            arr.append(i);
        }
        System.out.println(arr);

        arr.insert(1, 100);
        System.out.println(arr);

        arr.prepend(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }
}
