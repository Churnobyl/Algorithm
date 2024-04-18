import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;
            while (left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum < arr[i]) left++;
                else if(arr[i] < sum) right--;
                else {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}