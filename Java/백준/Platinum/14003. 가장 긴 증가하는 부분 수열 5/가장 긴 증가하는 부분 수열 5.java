import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, dp, path;
    static ArrayList<Integer> lis = new ArrayList<>();
    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];  // LIS의 길이 저장
        path = new int[n]; // 역추적을 위한 배열
        index = new int[n]; // LIS 위치 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(path, -1);

        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(lis, arr[i]);
            if (pos < 0) pos = -pos - 1; // lower_bound 찾기

            if (pos == lis.size()) lis.add(arr[i]);
            else lis.set(pos, arr[i]); // LIS 길이 유지

            dp[i] = pos + 1; // LIS 길이 저장
            index[pos] = i; // LIS 위치 저장
            if (pos > 0) path[i] = index[pos - 1]; // 이전 원소 연결
        }

        // LIS 길이 출력
        System.out.println(lis.size());

        // LIS 실제 수열 역추적
        Stack<Integer> lisStack = new Stack<>();
        for (int i = index[lis.size() - 1]; i != -1; i = path[i]) {
            lisStack.push(arr[i]);
        }

        // LIS 수열 출력
        while (!lisStack.isEmpty()) {
            System.out.print(lisStack.pop() + " ");
        }
    }
}
