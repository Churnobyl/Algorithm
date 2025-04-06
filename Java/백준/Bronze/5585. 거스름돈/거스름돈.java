import java.io.*;
import java.util.*;

public class Main {

    static int[] coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int coin : coins) {
            int num = N / coin;
            cnt += num;
            N -= coin * num;
            if (N == 0) break;
        }

        System.out.println(cnt);
    }
}
