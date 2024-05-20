package pta._2024520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution_520_3 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int x = (int) st.nval;
        int curNum = 0;
        while (x == 1 || x == 0) {
            if (x == 1) {
                curNum++;
            } else {
                System.out.println(curNum);
            }
            st.nextToken();
            x = (int) st.nval;
        }
    }
}
