import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int winner = 0;
        int score = 0;

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int candiScore = 0;

            for (int j = 0; j < 4; j++) {
                candiScore += Integer.parseInt(st.nextToken());
            }

            if (score < candiScore) {
                winner = i;
                score = candiScore;
            }
        }

        System.out.println(winner + " " + score);
    }
}
