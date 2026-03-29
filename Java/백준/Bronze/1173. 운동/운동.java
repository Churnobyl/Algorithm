import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        int exercise = 0;
        int pulse = m;

        while (exercise < N) {
            if (pulse + T <= M) {
                pulse += T;
                exercise++;
            } else {
                pulse -= R;
                if (pulse < m) pulse = m;
            }
            time++;
        }

        System.out.println(time);
    }
}