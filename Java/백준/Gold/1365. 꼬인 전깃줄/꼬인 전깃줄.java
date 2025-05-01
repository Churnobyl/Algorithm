import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> LIS = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            int index = Collections.binarySearch(LIS, num);
            if (index < 0) index = -(index + 1);

            if (LIS.size() == index) {
                LIS.add(num);
            } else {
                LIS.set(index, num);
            }
        }

        System.out.println(N - LIS.size());
    }
}
