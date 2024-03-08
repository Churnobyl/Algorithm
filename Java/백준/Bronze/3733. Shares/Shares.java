import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.println(c / (b + 1));
		}
		sc.close();
	}
}