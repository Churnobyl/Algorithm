import java.io.*;
import java.util.*;

public class Main {
    static String line;
    static int len;
    static Map<String, List<String>> vocabulary = new HashMap<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();
        len = line.length();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String key = makeKey(word);
            vocabulary.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len] = 0;

        for (int i = len - 1; i >= 0; i--) {
            int[] arr = new int[26];
            for (int j = i; j < len; j++) {
                arr[line.charAt(j) - 'a']++;

                String key = makeKey(arr);
                if (vocabulary.containsKey(key)) {
                    for (String word : vocabulary.get(key)) {
                        if (word.length() == j - i + 1) {
                            int cost = calcCost(word, line.substring(i, j + 1));
                            if (dp[j + 1] != Integer.MAX_VALUE) {
                                dp[i] = Math.min(dp[i], dp[j + 1] + cost);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[0] == Integer.MAX_VALUE ? -1 : dp[0]);
    }

    private static String makeKey(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return makeKey(count);
    }

    private static String makeKey(int[] count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    private static int calcCost(String a, String b) {
        int cost = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cost++;
        }
        return cost;
    }
}
