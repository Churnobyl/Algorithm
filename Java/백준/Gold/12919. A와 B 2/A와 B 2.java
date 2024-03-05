import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String S, T;
	static boolean isDab = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		dfs(T, true);
		System.out.println(isDab ? 1 : 0);
	}
	
	private static void dfs(String line, boolean isFront) {
		if (line.length() == S.length()) {
			if (isFront && line.equals(S))
				isDab = true;
			
			if (!isFront) {
				boolean check = true;
				for (int i = 0; i < S.length(); i++) {
					if (S.charAt(i) != line.charAt(S.length() - 1 - i)) {
						check = false;
						break;
					}
				}
				
				if (check) isDab = true;
			}
			
			return;
		}
		
		if (isFront) {
			if (line.charAt(line.length() - 1) == 'A') {
				dfs(line.substring(0, line.length() - 1), true);
			}
			
			if (line.charAt(0) == 'B') {
				dfs(line.substring(1, line.length()), false);
			}
		} else {
			if (line.charAt(line.length() - 1) == 'B') {
				dfs(line.substring(0, line.length() - 1), true);
			}
			
			if (line.charAt(0) == 'A') {
				dfs(line.substring(1, line.length()), false);
			}					
		}
	}
}
