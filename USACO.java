import java.io.*;
import java.util.*;
public class USACO {
	public static int bronze(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
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
			int max = findMax(instruc[0] - 1, instruc[1] - 1, field); //find highest elevation in the required 3 x 3 square of the field
			int finalElev = max - instruc[2]; //find possible highest elevation after cowstomping
			
			for (int i = instruc[0] - 1; i < instruc[0] + 2; i++) { //loop through 3x3 square
				for (int j = instruc[1] - 1; j < instruc[1] + 2; j++) {
					if (field[i][j]  > finalElev && finalElev >= 0) { //if higher than the post-cowstomping elevation, the 
						field[i][j] = finalElev;
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
		return (totalDepth * 72 * 72);

	}
	private static int findMax(int r, int c, int[][] field) {
		int max = 0;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (field[i][j] > max) {
					max = field[i][j];
				}
			}
		}
		return max;
	}
	public static int silver(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		int[][] field = new int[r][c];
		for (int i = 0; i < r; i++) {
			String row = sc.next();
			for (int j = 0; j < c; j++) {
				if (row.substring(j, j + 1).equals("*")) {
					field[i][j] = -1;
				}
			}
		}
		int startr = sc.nextInt() - 1;
		int startc = sc.nextInt() - 1;
		int finr = sc.nextInt() - 1;
		int finc = sc.nextInt() - 1;
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
					else {
						newField[j][k] = -1;
					}
				}
			}
			field = newField;
		}
		return field[finr][finc];	
	}
}
