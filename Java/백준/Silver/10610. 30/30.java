import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int sum = 0;
        boolean hasZero = false;
        char[] arr = N.toCharArray();

        for (char c : arr) {
            int digit = c - '0';
            sum += digit;
            if (digit == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();
        System.out.println(sb.toString());
    }
}
