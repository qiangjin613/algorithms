package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/image-smoother/">661. 图片平滑器</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_661 {

    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int sum = 0, cnt = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < img.length && y >= 0 && y < img[i].length) {
                            sum += img[x][y];
                            cnt++;
                        }
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution_661().imageSmoother(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        })));
        System.out.println(Arrays.deepToString(new Solution_661().imageSmoother(new int[][]{
                {2, 3}
        })));
    }
}
