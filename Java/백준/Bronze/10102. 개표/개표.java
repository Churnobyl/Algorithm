import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] votes = br.readLine().toCharArray();

        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            if (votes[i] == 'A') a++;
            else b++;
        }

        if (a > b) System.out.println("A");
        else if (a < b) System.out.println("B");
        else System.out.println("Tie");
    }
}