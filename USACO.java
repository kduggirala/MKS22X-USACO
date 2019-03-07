import java.io.*;
import java.util.*;
public class USACO {
	public static void main(String[] args) {
		try {
			System.out.println(bronze(args[0]));
			System.out.println(silver(args[1]));
		}
		catch(FileNotFoundException e) {
			System.out.println("NO");
		}
	}
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
		Scanner sc = new Scanner(filename);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		int[][] field = new int[r][c];
		for (int i = 0; i < r; i++) {
			String row = sc.nextLine();
			for (int j = 0; j < c; j++) {
				if (row.substring(j, j + 1).equals("*")) {
					field[i][j] = -1;
				}
			}
		}
		int startr = sc.nextInt();
		int startc = sc.nextInt();
		int finr = sc.nextInt();
		int finc = sc.nextInt();
		final int[][] coords = {
				{1, 0},
				{0, 1},
				{-1, 0},
				{0, -1}
		};
		sc.close();
		field[startr][startc] = 1;
		for (int i = 0; i < t; i++) {
			int[][] newField = new int[r][c];
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (field[j][k] != -1) {
						int newValue = 0;
						for (int [] coord : coords ) {
							try {
								if (field[j + coord[0]][k + coord[1]] != -1) {
									newValue += field[j + coord[0]][k + coord[1]];
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
							}
						}
						newField[j][k] = newValue;
					}
				}
			}
			field = newField;
		}
		return field[finr][finc];	
	}
}
