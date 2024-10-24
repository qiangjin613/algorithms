package leetcode;

/**
 * <a href="https://leetcode.cn/problems/can-place-flowers/">605. 种花问题</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            // 查看该位置是否能种花
            if (flowerbed[i] == 0 &&
                    (i - 1 < 0 || flowerbed[i - 1] == 0) &&
                    (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)
            ){
                flowerbed[i] = 1;
                n--;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_605().canPlaceFlowers(new int[]{1,0,0,0,1},1));
        System.out.println(new Solution_605().canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }
}
