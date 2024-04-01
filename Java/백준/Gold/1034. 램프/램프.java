import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, maxValue;
	static int nowValue;
	static boolean[][] map;
	static boolean[] visited;
	static int[] rows;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> sameLine = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            sameLine.put(line, sameLine.getOrDefault(line, 0) + 1);
        }

        int K = Integer.parseInt(br.readLine());

        int maxValue = 0;
        for (String key : sameLine.keySet()) {
            int zeroCount = 0;
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == '0') zeroCount++;
            }

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                maxValue = Math.max(maxValue, sameLine.get(key));
            }
        }

        System.out.println(maxValue);
	}
}
