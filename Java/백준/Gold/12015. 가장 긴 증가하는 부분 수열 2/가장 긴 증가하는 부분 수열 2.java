import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(result, num);
            if (idx < 0) idx = - (idx + 1);

            if (idx == result.size()) result.add(num);
            else result.set(idx, num);
        }

        System.out.println(result.size());
    }
}
