package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/self-dividing-numbers/">728. 自除数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        // 定义操作：上、下、左、右
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        int sourceColor = image[sr][sc];
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] curIdx = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = curIdx[0] + dx[i];
                int y = curIdx[1] + dy[i];
                // x、y 的边界检查 + 颜色判断
                if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == sourceColor) {
                    queue.offer(new int[] {x, y});
                    // 将当前节点入队时，要将其颜色进行更新，防止再次入队
                    image[x][y] = color;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution_733().floodFill(
                new int[][]{{1,1,1}, {1,1,0}, {1,0,1}},
                1,
                1,
                2)));
    }
}
