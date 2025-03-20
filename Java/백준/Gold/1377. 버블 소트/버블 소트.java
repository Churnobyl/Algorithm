import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int max = 0;

        for (int i = 0; i < N; i++) {
            int[] d = arr[i];

            if (d[1] - i > 0) {
                max = Math.max(max, d[1] - i);
            }
        }

        System.out.println(max + 1);
    }
}
