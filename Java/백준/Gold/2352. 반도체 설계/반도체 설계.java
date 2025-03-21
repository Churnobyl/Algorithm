import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> LIS = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Collections.binarySearch(LIS, arr[i]);
            if (index < 0) index = -(index + 1);

            if (index == LIS.size()) {
                LIS.add(arr[i]);
            } else {
                LIS.set(index, arr[i]);
            }
        }

        System.out.println(LIS.size());
    }
}
