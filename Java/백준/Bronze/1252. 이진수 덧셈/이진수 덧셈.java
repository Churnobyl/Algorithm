import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        BigInteger a = new BigInteger(A, 2);
        BigInteger b = new BigInteger(B, 2);

        System.out.println(a.add(b).toString(2));
    }
}
