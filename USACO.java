import java.io.*;
import java.util.*;
public class USACO {
	public static int bronze(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(filename);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] field = new int[r][c];
		int e = sc.nextInt();
		int n = sc.nextInt();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				field[i][j] = sc.nextInt();
			}
		}
		int[][] instrucs = new int[n][3];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < 3; i++) {
				instrucs[k][i] = sc.nextInt();
			}
		}
		for (int[] instruc : instrucs) {
			for (int k = 0; k < instruc[2]; k++) {
				int max = findMax(instruc[0] - 1, instruc[1] - 1, field);
				for (int i = instruc[0] - 1; i < instruc[0] + 2; i++) {
					for (int j = instruc[1] - 1; j < instruc[1] + 2; j++) {
						if (field[i][j] == max) {
							field[i][j]--;
						}
					}
				}
			}
		}
		int totalDepth = 0;
		for (int[] row : field) {
			for (int a : row) {
				if (e - a > 0) {
					totalDepth += (e-a);
				}
			}
		}
		sc.close();
		return totalDepth * 72 * 72;
		
	}
	private static int findMax(int r, int c, int[][] field) {
		int max = 0;
		for (int i = r; i <= r + 2; i++) {
			for (int j = c; j <= c + 2; j++) {
				if (field[r][c] > max) {
					max = field[r][c];
				}
			}
		}
		return max;
	}
	public static int silver(String filename) throws FileNotFoundException {
		return 0;	
	}
}
