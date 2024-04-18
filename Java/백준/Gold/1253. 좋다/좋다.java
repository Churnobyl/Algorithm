import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int goodCount = 0;
        
        for (int k = 0; k < N; k++) {
            if (isGood(k)) {
                goodCount++;
            }
        }
        
        System.out.println(goodCount);
    }
    
    private static boolean isGood(int k) {
        int target = arr[k];
        for (int i = 0; i < N; i++) {
            if (i == k) continue;
            for (int j = i + 1; j < N; j++) {
                if (j == k) continue;
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
