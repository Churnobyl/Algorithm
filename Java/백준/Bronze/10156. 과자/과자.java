import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.parseInt(st.nextToken());
        answer *= Integer.parseInt(st.nextToken());
        answer -= Integer.parseInt(st.nextToken());
        System.out.println(answer >= 0 ? answer : 0);
    }
}
