import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String find = br.readLine();

        int[] pi = getPi(find);

        int j = 0;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != find.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == find.charAt(j)) {
                if (j == find.length() - 1) {
                    answer++;
                    j = 0;
                } else {
                    j++;
                }
            }
        }

        System.out.println(answer);
    }

    private static int[] getPi(String str) {
        int len = str.length();
        int j = 0;
        int[] pi = new int[len];

        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }
}
