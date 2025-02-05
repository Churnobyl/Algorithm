import java.io.*;
import java.util.*;

public class Main {
    static class Wire {
        int a, b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Wire[] wires = new Wire[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(a, b);
        }

        // Step 1: Sort wires based on position A
        Arrays.sort(wires, Comparator.comparingInt(w -> w.a));

        // Step 2: Extract B positions
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = wires[i].b;
        }

        // Step 3: Find LIS length of B values
        int lisLength = findLIS(B);

        // Step 4: Compute the minimum removals
        System.out.println(N - lisLength);
    }

    private static int findLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -(idx + 1);
            
            if (idx == lis.size()) {
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }
        return lis.size();
    }
}
