import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;

            int[] arr = new int[4];

            for (int i = 0; i < line.length(); i++) {
                char data = line.charAt(i);

                if ('A' <= data && data <= 'Z') arr[1]++;
                else if ('a' <= data && data <= 'z') arr[0]++;
                else if ('0' <= data && data <= '9') arr[2]++;
                else arr[3]++;
            }

            for (int i = 0; i < 4; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}