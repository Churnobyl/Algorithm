import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String T, P;
	static int n, m;
	static int[] pi;
	static int total;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = br.readLine();
        P = br.readLine();
        
        n = T.length();
        m = P.length();
        
        pi = getPi(P);
        
        int begin = 0;
        int matched = 0;

        while (begin <= n - m) {
        	if (matched < m && T.charAt(begin + matched) == P.charAt(matched)) {
        		++matched;
        		
        		if (matched == m) {
        			total++;
        			sb.append((begin + 1) + " ");
        		}
        	} else {
        		if (matched == 0) {
        			++begin;
        		} else {
        			begin += matched - pi[matched - 1];
        			matched = pi[matched - 1];
        		}
        		
        	}
        }
        
        System.out.println(total);
        System.out.println(sb);
    }

	private static int[] getPi(String x) {
		int begin = 1;
		int matched = 0;
		
		int[] cache = new int[m];
		
		while (begin + matched < m) { // 패턴 끝까지
			if (x.charAt(begin + matched) == x.charAt(matched)) {
				matched++;
				cache[begin + matched - 1] = matched;
			} else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - cache[matched - 1];
					matched = cache[matched - 1];
				}
			}
		}
		
		return cache;
	}
}