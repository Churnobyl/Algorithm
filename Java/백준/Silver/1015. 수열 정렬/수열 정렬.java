import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            P[arr[i][1]] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i]+ " ");
        }
    }
}
