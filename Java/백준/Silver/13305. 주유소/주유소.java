import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int[] road, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        road = new int[N - 1];
        cost = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        BigInteger answer = new BigInteger("2000000000");
        int totalLength = 0;

        for (int i = N - 2; i >= 0; i--) {
            int r = road[i];
            int c = cost[i];
            totalLength += road[i];

            BigInteger candi1 = answer.add(new BigInteger(String.valueOf(c)).multiply(new BigInteger(String.valueOf(r))));
            BigInteger candi2 = new BigInteger(String.valueOf(c)).multiply(new BigInteger(String.valueOf(totalLength)));

            answer = candi1.min(candi2);
        }

        System.out.println(answer);
    }
}
