package leetcode;

/**
 * <a href="https://leetcode.cn/problems/shortest-completing-word/">748. 最短补全词</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plateCnt = getNumCnt(licensePlate);
        int ans = -1;
        for (int i = 0; i < words.length; i++) {
            int[] numCnt = getNumCnt(words[i]);
            boolean flag = true;
            for (int j = 0; j < plateCnt.length; j++) {
                if (plateCnt[j] > numCnt[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag && (ans < 0 || words[i].length() < words[ans].length())) {
                ans = i;
            }
        }
        return words[ans];
    }

    private int[] getNumCnt(String str) {
        int[] ans = new int[26];
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                ans[c - 'a'] ++;
            } else if (c >= 'A' && c <= 'Z') {
                ans[c - 'A'] ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_748().shortestCompletingWord(
                "1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new Solution_748().shortestCompletingWord(
                "1s3 456",
                new String[]{"looks","pest","stew","show"}));
    }
}
