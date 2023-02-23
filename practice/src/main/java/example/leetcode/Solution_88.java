package example.leetcode;

public class Solution_88 {

    /**
     * 双指针 + 中间数组
     * <p>
     * Note: 这里的 if 不可合并，因为如果合并后是会出现 ArrayIndexOutOfBoundsException 的。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, p = 0;
        int[] mergeArray = new int[m + n];
        while (i < m || j < n) {
            if (i == m) {
                mergeArray[p] = nums2[j++];
            } else if (j == n) {
                mergeArray[p] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                mergeArray[p] = nums1[i++];
            } else {
                mergeArray[p] = nums2[j++];
            }
            p++;
        }
        for (int i1 = 0; i1 < nums1.length; i1++) {
            nums1[i1] = mergeArray[i1];
        }
    }

    /**
     * 优化：逆向双指针
     * <p>
     * Note: 通过数学可证明，在逆序遍历的过程中，nums1 的指针 i 后面的位置永远足够容纳被插入的元素，即不会出现 nums1 的元素被覆盖的情况。
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // i 和 j 分别指向 nums1、nums2 的最后一个位置，p 指向 nums1 写入的位置
        int i = m - 1, j = n - 1, p = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[p] = nums2[j--];
            } else if (j < 0) {
                nums1[p] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[p] = nums1[i--];
            } else {
                nums1[p] = nums2[j--];
            }
            p--;
        }
    }

    public static void main(String[] args) {
        new Solution_88().merge2(new int[] {0}, 0, new int[] {2}, 1);
    }
}
