import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            sum += x;
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int mode = 0;
        int maxCnt = -1;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int cnt = e.getValue();
            if (cnt > maxCnt || (cnt == maxCnt && val < mode)) {
                maxCnt = cnt;
                mode = val;
            }
        }

        System.out.println(sum / 10);
        System.out.println(mode);
    }
}