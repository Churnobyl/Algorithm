import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Sticker {
	int h, w, count;
	int[][] shape;
	
	public Sticker(int h, int w) {
		this.h = h;
		this.w = w;
		
		shape = new int[h][w];
	}
}

public class Main {
	static int N, M, K, total;
	static Sticker[] stickers;
	static int[][] laptop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		laptop = new int[N][M];
		stickers = new Sticker[K];
		stickerSetting(br);
		attachingProcess();
		System.out.println(total);
	}

	private static void attachingProcess() {
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 4; j++) {
				boolean isEnd = find(i);
				if (isEnd) break;
				if (j == 3) break;
				rotate(i);
			}
		}
	}
	
	private static boolean find(int stickerNum) {
		Sticker sticker = stickers[stickerNum];
		
		for (int i = 0; i < N - sticker.h + 1; i++) {
			for (int j = 0; j < M - sticker.w + 1; j++) {
				if (find0(i, j, sticker)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean find0(int i, int j, Sticker sticker) {
		boolean isPossible = true;
		
		for (int k = 0; k < sticker.h; k++) {
			for (int k2 = 0; k2 < sticker.w; k2++) {
				if (sticker.shape[k][k2] == 1) {
					if (laptop[i + k][j + k2] != 0) {
						isPossible = false;
						break;						
					}
				}
			}
		}
		
		if (isPossible) {
			for (int k = 0; k < sticker.h; k++) {
				for (int k2 = 0; k2 < sticker.w; k2++) {
					if (sticker.shape[k][k2] == 1) {
						laptop[i + k][j + k2] = 1;
					}
				}
			}
			
			total += sticker.count;
			
			return true;
		} else {
			return false;
		}
	}

	private static void rotate(int stickerNum) {
		Sticker sticker = stickers[stickerNum];
		Sticker newSticker = new Sticker(sticker.w, sticker.h);
		newSticker.count = sticker.count;
		
		for (int i = 0; i < sticker.w; i++) {
			for (int j = 0; j < sticker.h; j++) {
				newSticker.shape[i][sticker.h - 1 - j] = sticker.shape[j][i];
			}
		}
		stickers[stickerNum] = newSticker;
	}

	
	

	private static void stickerSetting(BufferedReader br) throws IOException {
		StringTokenizer st;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sn = Integer.parseInt(st.nextToken());
			int sm = Integer.parseInt(st.nextToken());
			stickers[i] = new Sticker(sn, sm);
			
			for (int j = 0; j < sn; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < sm; j2++) {
					stickers[i].shape[j][j2] = Integer.parseInt(st.nextToken());
					if (stickers[i].shape[j][j2] == 1) stickers[i].count++;
				}
			}
		}
	}
}
