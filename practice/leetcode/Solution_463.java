package leetcode;

/**
 * <a href="https://leetcode.cn/problems/hamming-distance/">461. 汉明距离</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_463 {

    /**
     * 遍历
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 若非陆地，快速返回
                if (grid[i][j] != 1) {
                    continue;
                }
                // 上：左边界 或 左边是海洋
                if (i - 1 < 0 || grid[i - 1][j] != 1) {
                    res ++;
                }
                // 下
                if (i + 1 >= grid.length || grid[i + 1][j] != 1) {
                    res ++;
                }
                // 左
                if (j - 1 < 0 || grid[i][j - 1] != 1) {
                    res ++;
                }
                // 右
                if (j + 1 >= grid[i].length || grid[i][j + 1] != 1) {
                    res ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_463().islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
        System.out.println(new Solution_463().islandPerimeter(new int[][]{
                {1}
        }));
    }
}
