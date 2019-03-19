import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class USACOTest {
	public static void main(String[] args) {
		try {
			for (int i = 1; i < 6; i++) {
				int myAnswer = USACO.bronze("makelake." + i + ".in");
				int answer = new Scanner(new File("makelake." + i + ".out")).nextInt();
				if (answer == myAnswer)
					System.out.println("Y");
				else
					System.out.println("N");
				myAnswer = USACO.silver("ctravel." + i + ".in");
				answer = new Scanner(new File("ctravel." + i + ".out")).nextInt();
				if (answer == myAnswer)
					System.out.println("Y");
				else
					System.out.println("N");
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
