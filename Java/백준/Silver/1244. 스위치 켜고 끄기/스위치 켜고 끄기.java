import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] switches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        switches = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            switches[i] = st.nextToken().equals("1");
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isMan = st.nextToken().equals("1");
            int num = Integer.parseInt(st.nextToken());
            run(isMan, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(switches[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void run(boolean isMan, int num) {
        if (isMan) {
            for (int i = num; i < N + 1; i += num) {
                switches[i] = !switches[i];
            }
        } else {
            switches[num] = !switches[num];
            for (int i = 1; num - i >= 1 && num + i <= N; i++) {
                if (switches[num - i] == switches[num + i]) {
                    switches[num - i] = !switches[num - i];
                    switches[num + i] = !switches[num + i];
                } else {
                    break;
                }
            }
        }
    }
}
