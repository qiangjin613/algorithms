package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/flipping-an-image">832. 翻转图像</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_832 {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int l = 0; l <= image[i].length / 2; l++) {
                int r = image[i].length - l - 1;
                if (l <= r && image[i][l] == image[i][r]) {
                    if (image[i][l] == 0) {
                        image[i][l] = 1;
                        image[i][r] = 1;
                    } else {
                        image[i][l] = 0;
                        image[i][r] = 0;
                    }
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution_832().flipAndInvertImage(new int[][]{
                {1,1,0},{1,0,1}, {0,0,0}
        })));

        System.out.println(Arrays.deepToString(new Solution_832().flipAndInvertImage(new int[][]{
                {1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}
        })));
    }
}
