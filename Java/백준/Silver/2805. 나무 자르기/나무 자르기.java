import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M;
    static int[] trees;
    static long[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        
        prefixSum = new long[N];
        prefixSum[0] = trees[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i-1] + trees[i];
        }

        long left = 0;
        long right = trees[N-1];
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (getCutWood(mid) >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
    
    static long getCutWood(long height) {
        int idx = upperBound(trees, (int)height);
        
        if (idx >= N) return 0;

        long total = prefixSum[N-1] - (idx == 0 ? 0 : prefixSum[idx-1]);
        long cut = total - (N - idx) * height;
        return cut;
    }
    
    static int upperBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
