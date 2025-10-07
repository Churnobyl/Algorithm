import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static HashMap<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp.put(0, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int walkTime = Integer.parseInt(st.nextToken());
            int walkEarn = Integer.parseInt(st.nextToken());
            int bikeTime = Integer.parseInt(st.nextToken());
            int bikeEarn = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> cache = new HashMap<>();

            for (Integer key : dp.keySet()) {
                int value = dp.get(key);

                int walkT = key + walkTime;
                if (walkT <= K) {
                    cache.put(walkT, Math.max(cache.getOrDefault(walkT, 0), value + walkEarn));
                }

                int bikeT = key + bikeTime;
                if (bikeT <= K) {
                    cache.put(bikeT, Math.max(cache.getOrDefault(bikeT, 0), value + bikeEarn));
                }
            }

            dp = cache;
        }

        int maxValue = 0;
        for (int val : dp.values()) {
            maxValue = Math.max(maxValue, val);
        }
        System.out.println(maxValue);
    }
}