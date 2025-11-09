import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }

                int a = getSum(o1);
                int b = getSum(o2);

                if (a != b) {
                    return Integer.compare(a, b);
                }

                return o1.compareTo(o2);
            }

            private int getSum(String str) {
                int sum = 0;

                for (int i = 0; i < str.length(); i++) {
                    char d = str.charAt(i);

                    if ('0' <= d && d <= '9') {
                        sum += d - '0';
                    }
                }

                return sum;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}