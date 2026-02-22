import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String seats = br.readLine().trim();

        int lCount = 0;
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'L') lCount++;
        }

        int couple = lCount / 2;
        int cupHolders = (N + 1) - couple;
        int answer = Math.min(N, cupHolders);

        System.out.println(answer);
    }
}