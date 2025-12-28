import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double ratio = D / Math.sqrt((double)H * H + (double)W * W);

        int height = (int) (H * ratio);
        int width  = (int) (W * ratio);

        System.out.println(height + " " + width);
    }
}
