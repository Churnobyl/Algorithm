import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxPrefixLength = -1;
        String resultS = "";
        String resultT = "";

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int prefixLength = getCommonPrefixLength(words[i], words[j]);

                if (prefixLength > maxPrefixLength) {
                    maxPrefixLength = prefixLength;
                    resultS = words[i];
                    resultT = words[j];
                }
            }
        }

        System.out.println(resultS);
        System.out.println(resultT);
    }

    private static int getCommonPrefixLength(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        int prefixLength = 0;

        for (int i = 0; i < minLength; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }

        return prefixLength;
    }
}