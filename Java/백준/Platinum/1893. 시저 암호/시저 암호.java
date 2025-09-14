import java.io.*;
import java.util.*;

public class Main {
    static char[] A, W, S;
    static Map<Character, Integer> charToIndex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            setting(br);
            List<Integer> result = run();
            sb.append(makeAnswer(result)).append("\n");
        }

        System.out.println(sb);
    }

    private static List<Integer> run() {
        List<Integer> result = new ArrayList<>();

        for (int X = 0; X < A.length; X++) {
            if (checkShift(X)) {
                result.add(X);
            }
        }

        return result;
    }

    private static boolean checkShift(int shift) {
        char[] decoded = decode(shift);
        return countOccurrences(decoded, W) == 1;
    }

    private static char[] decode(int shift) {
        char[] decoded = new char[S.length];
        for (int i = 0; i < S.length; i++) {
            int pos = charToIndex.get(S[i]);
            int newPos = (pos - shift + A.length) % A.length;
            decoded[i] = A[newPos];
        }
        return decoded;
    }

    private static int countOccurrences(char[] text, char[] pattern) {
        if (pattern.length > text.length) return 0;

        int[] pi = getPi(pattern);
        int count = 0;
        int j = 0;

        for (int i = 0; i < text.length; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (text[i] == pattern[j]) {
                j++;
            }
            if (j == pattern.length) {
                count++;
                if (count > 1) return count;
                j = pi[j - 1];
            }
        }

        return count;
    }

    private static int[] getPi(char[] pattern) {
        int[] pi = new int[pattern.length];
        int j = 0;

        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    private static String makeAnswer(List<Integer> result) {
        Collections.sort(result);

        switch (result.size()) {
            case 0:
                return "no solution";
            case 1:
                return String.format("unique: %d", result.get(0));
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("ambiguous: ");
                for (int i = 0; i < result.size(); i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(result.get(i));
                }
                return sb.toString();
        }
    }

    private static void setting(BufferedReader br) throws IOException {
        A = get(br.readLine());
        W = get(br.readLine());
        S = get(br.readLine());
        
        charToIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            charToIndex.put(A[i], i);
        }
    }

    private static char[] get(String s) {
        return s.toCharArray();
    }
}