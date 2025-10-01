import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Integer> LIS = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int box = Integer.parseInt(st.nextToken());

            int idx = Collections.binarySearch(LIS, box);

            if (idx < 0) idx = -(idx + 1);

            if (idx == LIS.size()) LIS.add(box);
            else LIS.set(idx, box);
        }

        System.out.println(LIS.size());
    }
}