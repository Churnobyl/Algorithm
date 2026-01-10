import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[4];
        for (int i = 0; i < 4; i++) a[i] = Integer.parseInt(br.readLine().trim());

        int b1 = Integer.parseInt(br.readLine().trim());
        int b2 = Integer.parseInt(br.readLine().trim());

        Arrays.sort(a); // 오름차순
        int sumTop3A = a[1] + a[2] + a[3]; // 상위 3개

        int topB = Math.max(b1, b2);

        System.out.println(sumTop3A + topB);
    }
}
