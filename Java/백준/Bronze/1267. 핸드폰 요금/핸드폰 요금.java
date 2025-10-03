import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int youngsik = 0;
        int minsik = 0;

        for (int i = 0; i < N; i++) {
            int call = Integer.parseInt(st.nextToken());

            youngsik += (int)Math.ceil((call + 1) / 30.0) * 10;
            minsik += (int)Math.ceil((call + 1) / 60.0) * 15;
        }

        if (youngsik > minsik) {
            System.out.println("M " + minsik);
        } else if (youngsik < minsik) {
            System.out.println("Y " + youngsik);
        } else {
            System.out.println("Y M " + minsik);
        }
    }
}