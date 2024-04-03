import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static int Sa, Sb, Ta, Tb, Slen, now;
	static String S, T;
	Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'A') Sa++;
			else Sb++;
			
			Slen++;
		}
		
		T = br.readLine();
		
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == 'A') Ta++;
			else Tb++;
			
			now++;
		}
		
		if (recursion(T, true)) System.out.println(1);
		else System.out.println(0);
	}
	
	private static boolean recursion(String X, boolean drt) {
		if (Ta < Sa || Tb < Sb) return false;
		
		if (Slen == now) {
			if (S.equals(X) && drt || new StringBuffer(X).reverse().toString().equals(S) && !drt) {
				return true;
			}
			else return false;
		}
		
		if (drt) {
			if (X.charAt(now - 1) == 'A') {
				now--;
				Ta--;
				if (recursion(X.substring(0, now), drt)) return true;
				now++;
				Ta++;
			}
			
			if (X.charAt(0) == 'B') {
				now--;
				Tb--;
				if (recursion(X.substring(1, now + 1), false)) return true;
				now++;
				Tb++;
			}
		}
		else {
			if (X.charAt(0) == 'A') {
				now--;
				Ta--;
				if (recursion(X.substring(1, now + 1), drt)) return true;
				now++;
				Ta++;
			}
			
			if (X.charAt(now - 1) == 'B') {
				now--;
				Tb--;
				if (recursion(X.substring(0, now), true)) return true;
				now++;
				Tb++;
			}
		}
		
		return false;
	}
}