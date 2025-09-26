import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[8][2];

        for (int i = 1; i < 9; i++) {
            arr[i - 1][0] = Integer.parseInt(br.readLine());
            arr[i - 1][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(b[0], a[0]);
            }
        });
        
        int sum = 0;
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            sum += arr[i][0];
            idx.add(arr[i][1]);
        }
        
        Collections.sort(idx);

        System.out.println(sum);

        for (Integer i : idx) {
            System.out.print(i + " ");
        }
    }
}