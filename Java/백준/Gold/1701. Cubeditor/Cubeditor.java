import java.io.*;
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            getPi(str.substring(i));
        }
        System.out.println(answer);
    }

    private static void getPi(String str) {
        int len = str.length();

        int[] pi = new int[len];
        int j = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
                answer = Math.max(answer, pi[i]);
            }
        }
    }
}
