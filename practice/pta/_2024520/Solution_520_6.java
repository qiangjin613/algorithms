package pta._2024520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Solution_520_6 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int x = (int) st.nval;
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < x; i++) {
            st.nextToken();
            int temp = (int) st.nval;
            num.add(temp);
        }

        st.nextToken();
        int y = (int) st.nval;
        for (int i = 0; i < y; i++) {
            st.nextToken();
            int check = (int) st.nval;
            if (num.contains(check)) {
                System.out.println("ZengYu");
            } else {
                System.out.println("JieDai");
            }
        }
    }
}
