import java.util.Scanner;

public class Example {

    /**
     * 各种排序算法
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 比较大小
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换元素
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 测试元素是否有序
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 在单行中打印数组
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split(" ");
        sort(a);
        // 尽管在一般都会从数学上证明算法的正确性，
        // 但在实现每个排序算法时加上这条语句仍然是必要的
        assert isSorted(a);
        sort(a);
    }
}
