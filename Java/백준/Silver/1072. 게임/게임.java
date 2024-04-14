import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        int rate = (int)((long) Y * 100 / X);
        
        if (rate == 100 || rate == 99) {
        	System.out.println(-1);
        	return;
        }
        
        long l = 1l;
        long r = 2_000_000_000l;
        
        while (l < r) {
        	long mid = (l + r) / 2;
        	int newRate = (int)((long)(Y + mid) * 100 / (X + mid));
        	if (newRate > rate) {
        		r = mid;
        	} else {
        		l = mid + 1;
        	}
        }
        
        System.out.println(l);
    }
}