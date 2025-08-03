import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer> LIS = new ArrayList<>();
    static int[] parent;
    static int[] lisIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        parent = new int[N];
        lisIndex = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            parent[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(LIS, arr[i]);
            if (idx < 0) idx = -(idx + 1);

            if (idx == LIS.size()) {
                LIS.add(arr[i]);
            } else {
                LIS.set(idx, arr[i]);
            }

            lisIndex[i] = idx;
            
            if (idx > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (lisIndex[j] == idx - 1 && arr[j] < arr[i]) {
                        parent[i] = j;
                        break;
                    }
                }
            }
        }
        
        System.out.println(LIS.size());
        
        List<Integer> result = new ArrayList<>();
        
        int lastIdx = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (lisIndex[i] == LIS.size() - 1) {
                lastIdx = i;
                break;
            }
        }
        
        while (lastIdx != -1) {
            result.add(arr[lastIdx]);
            lastIdx = parent[lastIdx];
        }
        
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }
}