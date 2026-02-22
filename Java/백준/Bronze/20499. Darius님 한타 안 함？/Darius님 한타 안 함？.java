import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] kda = Arrays.stream(br.readLine().split("/")).mapToInt(Integer::parseInt).toArray();
        int K = kda[0];
        int D = kda[1];
        int A = kda[2];

        if (K + A < D || D == 0) System.out.println("hasu");
        else System.out.println("gosu");
    }
}
