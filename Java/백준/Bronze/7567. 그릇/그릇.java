import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] dishes = br.readLine().toCharArray();
        boolean isStraight = true;
        int result = 0;

        for (int i = 0; i < dishes.length; i++) {
            if (i == 0) {
                isStraight = dishes[i] == '(';
                result += 10;
                continue;
            }

            if (isStraight) {
                if (dishes[i] == '(') {
                    result += 5;
                } else {
                    result += 10;
                    isStraight = false;
                }
            } else {
                if (dishes[i] == '(') {
                    result += 10;
                    isStraight = true;
                } else {
                    result += 5;
                }
            }
        }

        System.out.println(result);
    }
}
