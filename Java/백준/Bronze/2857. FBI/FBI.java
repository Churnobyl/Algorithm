import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] fbi = new char[] {'F', 'B', 'I'};

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 1; i < 6; i++) {
            String line = br.readLine();

            int idx = 0;

            for (int j = 0; j < line.length(); j++) {
                char next = line.charAt(j);

                if (fbi[idx] == next) {
                    if (idx > 1) {
                        cnt++;
                        sb.append(i).append(" ");
                        break;
                    } else {
                        idx++;
                    }
                } else {
                    idx = 0;
                    if (fbi[0] == next) idx++;
                }
            }
        }

        if (cnt == 0) System.out.println("HE GOT AWAY!");
        else System.out.println(sb);
    }
}