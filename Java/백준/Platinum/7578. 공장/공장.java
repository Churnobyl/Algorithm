import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] cables;
    static int[] arr;
    static long ans;
    static Map<Integer, Integer> numbering = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cables = new int[N][2];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            numbering.put(next, i + 1);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            cables[i][0] = numbering.get(next);
            cables[i][1] = i + 1;
        }

        Arrays.sort(cables, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; i++) {
            arr[i] = cables[i][1];
        }

        divide(arr);
        System.out.println(ans);
    }

    public static int[] divide(int[] arr) {
        if (arr.length < 2) return arr;

        int mid = arr.length / 2;

        int[] left = divide(Arrays.copyOfRange(arr, 0, mid));
        int[] right = divide(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] newArr = new int[left.length + right.length];
        int idx = 0;
        int lIdx = 0;
        int rIdx = 0;

        while ((lIdx < left.length) && (rIdx < right.length)) {
            if (left[lIdx] > right[rIdx]) {
                newArr[idx] = right[rIdx];
                rIdx++;
                idx++;
                ans += left.length - lIdx;
            } else {
                newArr[idx] = left[lIdx];
                lIdx++;
                idx++;
            }
        }

        if (lIdx == left.length) {
            while (rIdx < right.length) {
                newArr[idx] = right[rIdx];
                rIdx++;
                idx++;
            }
        } else {
            while (lIdx < left.length) {
                newArr[idx] = left[lIdx];
                lIdx++;
                idx++;
            }
        }

        return newArr;
    }
}
