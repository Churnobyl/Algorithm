import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        List<Integer> LIS = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            int idx = Collections.binarySearch(LIS, next, (a, b) -> Integer.compare(b, a));
            if (idx < 0) idx = - (idx + 1);

            if (idx == LIS.size()) LIS.add(next);
            else LIS.set(idx, next);
        }
        System.out.println(LIS.size());
    }
}
