import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];

            int sameCount = 0;
            int num = 0;

            for (int j = 0; j < 3; j++) {
                int data = Integer.parseInt(st.nextToken());
                arr[data]++;

                if (sameCount < arr[data] || (sameCount == arr[data] && num < data)) {
                    sameCount = arr[data];
                    num = data;
                }
            }

            switch (sameCount) {
                case 3:
                    max = Math.max(max, 10000 + num * 1000);
                    break;
                case 2:
                    max = Math.max(max, 1000 + num * 100);
                    break;
                case 1:
                    max = Math.max(max, num * 100);
                    break;
            }
        }

        System.out.println(max);
    }
}