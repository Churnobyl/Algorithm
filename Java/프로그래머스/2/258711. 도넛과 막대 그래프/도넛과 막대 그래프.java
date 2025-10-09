import java.util.*;

class Solution {
    static int max;
    static int min = Integer.MAX_VALUE;
    static int[] in, out;
    static boolean[] isExist;
    
    public int[] solution(int[][] edges) {
        setting(edges);
        
        int root = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        for (int i = min; i < max + 1; i++) {
            if (!isExist[i]) continue;
            
            if (in[i] == 0 && out[i] >= 2) {
                root = i;
            } else if (out[i] == 0) {
                stick++;
            } else if (in[i] >= 2 && out[i] == 2) {
                eight++;
            }
        }
        
        int total = out[root];
        donut = total - stick - eight;
        
        return new int[] {root, donut, stick, eight};
    }
    
    public void setting(int[][] edges) {
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            min = Math.min(min, a);
            min = Math.min(min, b);
            max = Math.max(max, a);
            max = Math.max(max, b);
        }

        in = new int[max + 1];
        out = new int[max + 1];
        isExist = new boolean[max + 1];
        
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            isExist[a] = true;
            isExist[b] = true;
            out[a]++;
            in[b]++;
        }
    }
}