import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[10];
        int[] B = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) B[i] = Integer.parseInt(st.nextToken());

        int scoreA = 0, scoreB = 0;
        char lastWinner = 'D';

        for (int i = 0; i < 10; i++) {
            if (A[i] > B[i]) {
                scoreA += 3;
                lastWinner = 'A';
            } else if (A[i] < B[i]) {
                scoreB += 3;
                lastWinner = 'B';
            } else {
                scoreA += 1;
                scoreB += 1;
            }
        }

        System.out.println(scoreA + " " + scoreB);

        if (scoreA > scoreB) System.out.println("A");
        else if (scoreA < scoreB) System.out.println("B");
        else System.out.println(lastWinner);
    }
}
