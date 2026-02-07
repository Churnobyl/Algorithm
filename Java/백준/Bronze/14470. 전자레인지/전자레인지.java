import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine().trim());
        int B = Integer.parseInt(br.readLine().trim());
        int C = Integer.parseInt(br.readLine().trim());
        int D = Integer.parseInt(br.readLine().trim());
        int E = Integer.parseInt(br.readLine().trim());

        int time = 0;

        if (A < 0) {
            time += (-A) * C; // A -> 0
            time += D;        // thaw at 0
            time += B * E;    // 0 -> B
        } else if (A == 0) {
            time += D;        // thaw at 0
            time += B * E;    // 0 -> B
        } else { // A > 0
            time += (B - A) * E; // A -> B
        }

        System.out.println(time);
    }
}
