import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return s.length() > 0;
    }

    private static String fizzBuzz(int n) {
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";
        return String.valueOf(n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int nextNumber;
        if (isNumber(a)) {
            nextNumber = Integer.parseInt(a) + 3;
        } else if (isNumber(b)) {
            nextNumber = Integer.parseInt(b) + 2;
        } else {
            nextNumber = Integer.parseInt(c) + 1;
        }

        System.out.println(fizzBuzz(nextNumber));
    }
}
