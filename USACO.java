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
		
		sc.close();
		return 0;
		
	}
	public static int silver(String filename) throws FileNotFoundException {
		return 0;	
	}
}