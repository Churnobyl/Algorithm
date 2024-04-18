import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String str;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			str = br.readLine();
			if (str.equals(".")) break;
			p = new int[str.length()];
			
			int begin = 1;
			int matched = 0;

			while (begin + matched < str.length()) {
				
				// 맞을 경우
				if (str.charAt(begin + matched) == str.charAt(matched)) {
					matched++;
					p[begin + matched - 1] = matched;
				}

				// 틀렸을 경우
				else {
					if (matched == 0) {
						begin++;
					} else {
						begin += matched - p[matched - 1];
						matched = p[matched - 1];
					}
				}
			}
			
			if (str.length() % (str.length() - p[str.length() - 1]) != 0) {
				System.out.println(1);
			} else {
				System.out.println(str.length() / (str.length() - p[str.length() - 1]));
			}
		}
	}
}