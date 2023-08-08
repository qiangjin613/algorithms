package leetcode;

/**
 * <a href = "https://leetcode.cn/problems/car-pooling/">1094. 拼车</a>
 */
public class Solution_1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000 + 1];
        for (int i = 0; i < trips.length; i++) {
            int from = trips[i][1];
            int to = trips[i][2];
            int numPassengers = trips[i][0];
            diff[from] += numPassengers;
            diff[to] -= numPassengers;
        }
        if (diff[0] > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1094().carPooling(new int[][]{{9,0,1},{3,3,7}}, 9));
        System.out.println(new Solution_1094().carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
        System.out.println(new Solution_1094().carPooling(new int[][]{{2,1,5},{3,5,7}}, 3));
    }
}
