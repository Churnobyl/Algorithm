import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int[] road, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
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

        int totalLength = 0;

        for (int i = 0; i < N - 1; i++) {
            totalLength += road[i];
        }

        BigInteger answer = new BigInteger(String.valueOf(cost[0])).multiply(new BigInteger(String.valueOf(totalLength)));
        BigInteger beforeCost = new BigInteger(String.valueOf(cost[0])).multiply(new BigInteger(String.valueOf(road[0])));
        int bestCost = cost[0];
        totalLength -= road[0];

        for (int i = 1; i < N - 1; i++) {
            int r = road[i];
            int c = cost[i];

            BigInteger a = beforeCost.add(new BigInteger(String.valueOf(c)).multiply(new BigInteger(String.valueOf(totalLength))));

            if (bestCost > c) {
                answer = a;
                bestCost = c;
                beforeCost = beforeCost.add(new BigInteger(String.valueOf(c)).multiply(new BigInteger(String.valueOf(r))));
            } else {
                beforeCost = beforeCost.add(new BigInteger(String.valueOf(bestCost)).multiply(new BigInteger(String.valueOf(r))));
            }
            totalLength -= r;
        }

        System.out.println(answer);
    }
}
