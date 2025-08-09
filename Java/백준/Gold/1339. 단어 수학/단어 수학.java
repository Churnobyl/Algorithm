import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] words;
    static List<Character> alphabets;
    static Map<Character, Long> weights;
    static int maxValue;
    static boolean[] used;
    static int[] assignment;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        Set<Character> alphabetSet = new HashSet<>();
        weights = new HashMap<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            for (char c : words[i].toCharArray()) {
                alphabetSet.add(c);
            }
        }

        alphabets = new ArrayList<>(alphabetSet);
        used = new boolean[10];
        assignment = new int[alphabets.size()];

        calculateWeights();

        alphabets.sort((a, b) -> Long.compare(weights.get(b), weights.get(a)));

        dfs(0);
        System.out.println(maxValue);
    }

    private static void calculateWeights() {
        for (char c : alphabets) {
            weights.put(c, 0L);
        }

        for (String word : words) {
            long weight = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                weights.put(c, weights.get(c) + weight);
                weight *= 10;
            }
        }
    }

    private static void dfs(int idx) {
        if (idx == alphabets.size()) {
            calculateResult();
            return;
        }

        for (int num = 9; num >= 0; num--) {
            if (used[num]) continue;

            assignment[idx] = num;
            used[num] = true;

            if (isPossibleToBetter(idx)) {
                dfs(idx + 1);
            }

            used[num] = false;
        }
    }

    private static boolean isPossibleToBetter(int currentIdx) {
        long currentSum = 0;
        long remainingMax = 0;

        for (int i = 0; i <= currentIdx; i++) {
            char c = alphabets.get(i);
            currentSum += weights.get(c) * assignment[i];
        }

        List<Integer> remainingNums = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            if (!used[i]) remainingNums.add(i);
        }

        for (int i = currentIdx + 1; i < alphabets.size(); i++) {
            if (i - currentIdx - 1 < remainingNums.size()) {
                char c = alphabets.get(i);
                remainingMax += weights.get(c) * remainingNums.get(i - currentIdx - 1);
            }
        }

        return currentSum + remainingMax > maxValue;
    }

    private static void calculateResult() {
        Map<Character, Integer> charToNum = new HashMap<>();
        for (int i = 0; i < alphabets.size(); i++) {
            charToNum.put(alphabets.get(i), assignment[i]);
        }

        int sum = 0;
        for (String word : words) {
            int num = 0;
            for (char c : word.toCharArray()) {
                num = num * 10 + charToNum.get(c);
            }
            sum += num;
        }

        maxValue = Math.max(maxValue, sum);
    }
}