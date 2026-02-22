import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int currentFatigue = 0;
        int totalWork = 0;

        for (int i = 0; i < 24; i++) {
            if (currentFatigue + A <= M) {
                currentFatigue += A;
                totalWork += B;
            } else {
                currentFatigue -= C;
                if (currentFatigue < 0) {
                    currentFatigue = 0;
                }
            }
        }

        System.out.println(totalWork);
    }
}