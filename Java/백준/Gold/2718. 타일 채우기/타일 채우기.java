import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp.add(1);
        dp.add(1);
        dp.add(5);
        dp.add(11);

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (dp.size() - 1 < N) {
                for (int j = dp.size(); j < N + 1; j++) {
                    dp.add(dp.get(j - 1) + 5 * dp.get(j - 2) + dp.get(j - 3) - dp.get(j - 4));
                }
            }

            sb.append(dp.get(N)).append("\n");
        }

        System.out.println(sb);
    }
}
