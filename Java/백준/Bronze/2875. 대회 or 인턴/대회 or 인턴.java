import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;

        for (int i = 0; i < K + 1; i++) {
            if (N - i < 2) continue;

            int nN = N - i;
            int nM = M - (K - i);

            max = Math.max(max, Math.min(nN / 2, nM));
        }

        System.out.println(max);
    }

}
