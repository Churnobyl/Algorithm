import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] rest;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        map.put(sum, 1);

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            sum = (sum + data) % M;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        long result = 0;

        for (Integer val : map.values()) {
            if (val >= 2) result += (long) val * (val - 1) / 2;
        }

        System.out.println(result);
    }
}