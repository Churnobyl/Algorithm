import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String operator = br.readLine();
        String B = br.readLine();

        switch (operator) {
            case "*":
                System.out.println("1" + "0".repeat(A.length() + B.length() - 2));
                break;
            case "+":
                BigInteger a = new BigInteger(A);
                BigInteger b = new BigInteger(B);
                System.out.println(a.add(b));
                break;
        }
    }
}